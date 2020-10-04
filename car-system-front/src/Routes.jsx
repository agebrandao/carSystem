import React from 'react'
import { Switch, Route, Redirect } from 'react-router'

import CarForm from './components/CarForm';
import CarList from './components/CarList';
import UserForm from './components/UserForm';
import UserList from './components/UserList';
import Home from './components/Home';
import Login from './components/Login';
import Header from './templates/Header';

export default props =>
    <Switch>        
        <Route exact path = '/' component={Login} />
        <Route path = '/login' component={Login}/>
        <Route path = '/home' component={Home}/>
        <Route path = '/cars' component={CarList}/>
        <Route path = '/car' component={CarForm}/>
        <Route path = '/car/:car' component={CarForm}/>   
        <Route path = '/users' component={UserList}/>
        <Route path = '/user' component={UserForm}/>
        <Route path = '/user/:user' component={UserForm}/>                
        <Redirect from='*' to='/' />
    </Switch>

   
//     <Switch>
//         <div >
//         <Route exact path="/login" component={LoginContainer}/>
//         <Route component={DefaultContainer}/>  
//         </div>
//     </Switch>

  
//   const LoginContainer = () => (
//     <div className="container">
//       <Route exact path="/" render={() => <Redirect to="/login" />} />
//       <Route path = '/login' component={Login}/>
//     </div>
//   )
  
  
//    const DefaultContainer = () => (
//       <div>
//       <Header />
//       <div className="container">        
//         <Route exact path = '/' component={Home} />
//         <Route path = '/cars' component={CarList}/>
//         <Route path = '/car' component={CarForm}/>
//         <Route path = '/car/:car' component={CarForm}/>   
//         <Route path = '/users' component={UserList}/>
//         <Route path = '/user' component={UserForm}/>
//         <Route path = '/user/:user' component={UserForm}/>                
//         <Redirect from='*' to='/' />
//       </div>
//       </div>
//    )