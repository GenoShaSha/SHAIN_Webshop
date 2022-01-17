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
import ShowProduct from './components/ShowProduct';
import UpdateMember from './components/UpdateMember';
import Cart from './components/Cart';
import { DataProvider } from './components/CartActions';
import Wishlist from './components/Wishlist';
import Order from './components/Order';
import Announcement from './components/Announcement';

function App() {
  return (
    <DataProvider>
    <div>
      <Router>
          <HeaderComponent />
            <div className="container">
              <Switch> 
                <Route path="/" exact component={Home}></Route>
                <Route path="/member" exact component={ListMemberComponent}></Route>
                <Route path="/SignUp" exact component={SignUp}></Route>
                <Route path="/:gender/:name" exact component={ShowProduct}></Route>
                <Route path="/category" exact component={AddCategory}></Route>
                <Route path="/ListOfCategory"exact component={ListCategory}></Route>
                <Route path="/SignIn" exact component={SignIn}></Route>
                <Route path="/SignOut"exact component={SignOut}></Route>
                <Route path="/AddProduct" exact component={AddProduct}></Route>
                <Route path="/:username" exact component={UpdateMember}></Route>
                <Route path="/Product/s/Cart" exact component={Cart}></Route>
                <Route path="/Product/s/Wishlist" exact component={Wishlist}></Route>
                <Route path="/Product/s/Order" exact component={Order}></Route>
                <Route path="/Product/new/Announcement" exact component={Announcement}></Route>
              </Switch>
            </div>
          </Router>
    </div>
    </DataProvider>
  );
}

export default App;
