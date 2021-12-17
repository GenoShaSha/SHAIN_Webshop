import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListMemberComponent from './components/ListMemberComponent';
import HeaderComponent from './components/HeaderComponent';
import Home from './components/Home';
import AddCategory from './components/AddCategory';
import ListCategory from './components/ListCategory';
import SignIn from './components/SignIn';
import SignOut from './components/SignOut';
import AddProduct from './components/AddProduct';
import SignUp from './components/SignUp';
import UpdateCategory from './components/UpdateCategory';
import ShowProduct from './components/ShowProduct';
import UpdateMember from './components/UpdateMember';


function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
            <div className="container">
              <Switch> 
                <Route path="/" exact component={Home}></Route>
                <Route path="/member" component={ListMemberComponent}></Route>
                <Route path="/SignUp" component={SignUp}></Route>
                <Route path="/:gender/:name" component={ShowProduct}></Route>
                <Route path="/category" component={AddCategory}></Route>
                <Route path="/ListOfCategory" component={ListCategory}></Route>
                <Route path="/SignIn" component={SignIn}></Route>
                <Route path="/SignOut" component={SignOut}></Route>
                <Route path="/AddProduct" component={AddProduct}></Route>
                <Route path="/:username" exact component={UpdateMember}></Route>
              </Switch>
            </div>
          </Router>
    </div>
  );
}

export default App;
