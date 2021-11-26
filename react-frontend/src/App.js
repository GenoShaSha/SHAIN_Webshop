import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListMemberComponent from './components/ListMemberComponent';
import HeaderComponent from './components/HeaderComponent';
import AddMember from './components/AddMember';
import Home from './components/Home';
import AddCategory from './components/AddCategory';
import ListCategory from './components/ListCategory';
import SignIn from './components/SignIn';
import SignOut from './components/SignOut';
import AddProduct from './components/AddProduct';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
            <div className="container">
              <Switch> http://localhost:3000/
                <Route path="/" exact component={Home}></Route>
                <Route path="/member" component={ListMemberComponent}></Route>
                <Route path="/SignUp" component={AddMember}></Route>
                <Route path="/PoloShirts" component={AddMember}></Route>
                <Route path="/:gender/:name" component={AddMember}></Route>
                <Route path="/category" component={AddCategory}></Route>
                <Route path="/ListOfCategory" component={ListCategory}></Route>
                <Route path="/SignIn" component={SignIn}></Route>
                <Route path="/SignOut" component={SignOut}></Route>
                <Route path="/AddProduct" component={AddProduct}></Route>





              </Switch>
            </div>
          </Router>
    </div>
  );
}

export default App;
