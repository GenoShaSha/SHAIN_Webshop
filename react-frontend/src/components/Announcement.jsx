import React, { useState, useEffect } from "react";
import SockJS from "sockjs-client";
import Stomp from "stompjs";
import { Card, CardImg, CardBody,
    CardTitle, CardText} from 'reactstrap';
  
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
    console.log(result.message);
    setReadMessage(readTheMsg => [...readTheMsg, result.message])
  }

  //TODO, add a solution for disconnection

  return (
<div>
{readTheMsg.map(message => (   
        <div>
          <div className="wrapper">
            <Card>
            <CardImg src={"https://buildingsmart-1xbd3ajdayi.netdna-ssl.com/wp-content/uploads/2020/03/feat_important-.jpg"} alt="Card image cap" />
            <CardBody>
              <CardTitle>ANNOUNCEMENT!</CardTitle>
              <CardText>{message}</CardText>
            </CardBody>
          </Card>
          <br></br>
        </div>
        </div>
        ))}
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
        <br></br>
      <Button onClick={sendMessage}>POST ANNOUNCEMENT</Button>
      </FormGroup>
      </Form>

    </div>
  );
}

export default Announcement;
