import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListMemberComponent from './components/ListMemberComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import AddMemberComponent from './components/AddMemberComponent';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
            <div className="container">
              <Switch> http://localhost:3000/
                <Route path="/" exact component={ListMemberComponent}></Route>
                <Route path="/member" component={ListMemberComponent}></Route>
                <Route path="/signUp" component={AddMemberComponent}></Route>
              </Switch>
            </div>
            <FooterComponent />
        </Router>
    </div>
  );
}

export default App;
