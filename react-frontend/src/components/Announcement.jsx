import React, { useState, useEffect } from "react";
import SockJS from "sockjs-client";
import Stomp from "stompjs";
import { Button, Form, FormGroup, Label, Input, FormText } from "reactstrap";

// Set the backend location

function Announcement() {
  const [stompClient, setStompClient] = useState(null);
  const [msgToSend, setSendMessage] = useState("");
  const [readTheMsg, setReadMessage] = useState([]);

  useEffect(() => {
    // use SockJS as the websocket client
    const socket = SockJS("http://localhost:8080/liveAnnouncement");
    // Set stomp to use websockets
    const stompClient = Stomp.over(socket);
    // connect to the backend
    stompClient.connect({}, () => {
      // subscribe to the backend
      stompClient.subscribe("/topic/announcement", (data) => {
        console.log(data);
        onMessageReceived(data);
      });
    });
    // maintain the client for sending and receiving
    setStompClient(stompClient);
  }, []);

  // send the data using Stomp
  function sendMessage() {
    if (msgToSend == "") {
      alert("Please write the announcement here!");
    } else {
      stompClient.send("/app/send", {}, JSON.stringify({ content: msgToSend }));
    }
  }

  // display the received data
  function onMessageReceived(data) {
    const result = JSON.parse(data.body);
    alert(result.message);
    console.log(result.message);
    readTheMsg.log(result.message);
  }

  //TODO, add a solution for disconnection

  return (
    <Form>
      <FormGroup>
        <Label for="newAnnouncement">NEW ANNOUNCEMENT: </Label>
        <Input
          type="announcement"
          name="announcement"
          id="newAnnouncement"
          placeholder=""
          onChange={(event) => setSendMessage(event.target.value)}
        />
      </FormGroup>
      <Button onClick={sendMessage}>POST ANNOUNCEMENT</Button>
    </Form>
  );
}

export default Announcement;
