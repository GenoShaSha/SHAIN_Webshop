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
import ListProduct from './components/ListProduct';
import UpdateProductQty from './components/UpdateProductQty';
import AuthorizedAsAdmin from './components/AuthorizedAsAdmin';
import AuthenticatedUser from './components/AuthenticatedUser';
import AuthorizedUser from './components/AuthorizedUser';

function App() {
  return (
    <DataProvider>
    <div>
      <Router>
          <HeaderComponent />
            <div className="container">
              <Switch> 
                <Route path="/" exact component={Home}></Route>
                <Route path="/member" exact component={AuthorizedAsAdmin(ListMemberComponent)}></Route>
                <Route path="/category" exact component={AuthorizedAsAdmin(AddCategory)}></Route>
                <Route path="/ListOfCategory"exact component={AuthorizedAsAdmin(ListCategory)}></Route>
                <Route path="/ListOfProduct"exact component={AuthorizedAsAdmin(ListProduct)}></Route>
                <Route path="/AddProduct" exact component={AuthorizedAsAdmin(AddProduct)}></Route>
                <Route path="/Product/qty/:artNumb" exact component={AuthorizedAsAdmin(UpdateProductQty)}></Route>
                <Route path="/SignIn" exact component={AuthenticatedUser(SignIn)}></Route>
                <Route path="/:username" exact component={AuthorizedUser(UpdateMember)}></Route>
                <Route path="/User/Profile/SignUp" exact component={AuthenticatedUser(SignUp)}></Route>
                <Route path="/:gender/:name" exact component={ShowProduct}></Route>
                <Route path="/Product/User/Cart" exact component={Cart}></Route>
                <Route path="/Product/User/Wishlist" exact component={Wishlist}></Route>
                <Route path="/Product/User/Order" exact component={Order}></Route>
                <Route path="/Product/new/Announcement" exact component={Announcement}></Route>
                <Route path="/User/Profile/SignOut"exact component={SignOut}></Route>
              </Switch>
            </div>
          </Router>
    </div>
    </DataProvider>
  );
}

export default App;
