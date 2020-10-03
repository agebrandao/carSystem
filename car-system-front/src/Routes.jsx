import React from 'react'
import { Switch, Route, Redirect } from 'react-router'

import CarForm from './components/CarForm';
import CarList from './components/CarList';
import UserForm from './components/UserForm';
import UserList from './components/UserList';
import Home from './components/Home';

export default props =>
    <Switch>
        <Route exact path = '/' component={Home} />
        <Route path = '/cars' component={CarList}/>
        <Route path = '/car' component={CarForm}/>
        <Route path = '/car/:car' component={CarForm}/>   
        <Route path = '/users' component={UserList}/>
        <Route path = '/user' component={UserForm}/>
        <Route path = '/user/:user' component={UserForm}/>                
        <Redirect from='*' to='/' />
    </Switch>