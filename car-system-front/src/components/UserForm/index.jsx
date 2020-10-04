import React, { useState, useEffect } from 'react';
import { Redirect } from 'react-router'
import { Link } from 'react-router-dom'

import DatePicker from "react-datepicker";

import ApiAxios from '../../config/apiAxios';
import Share from '../../share';
import CarList from '../CarList';

export default function UserForm(props) {

    const [user, setUser] = useState('');

    const [id, setId] = useState();    
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [birthday, setBirthday] = useState('');
    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');
    const [phone, setPhone] = useState('');

    const [car, setCar] = useState('');
    const [cars, setCars] = useState([]);

    const [redirect, setRedirect] = useState(false);

    useEffect(() =>{
        cleanInput();

        // For edit 
        if(props && props.location && props.location.user){

            const userEdit = {
                "id": props.location.user.id,
                "firstName": props.location.user.firstName,
                "lastName": props.location.user.lastName,
                "email": props.location.user.email,
                "birthday": props.location.user.birthday,
                "login": props.location.user.login,
                "password": props.location.user.password,
                "phone": props.location.user.phone,   
                "cars" : props.location.user.cars         
            }

            setUser(userEdit);                              
        }

    },[]);

    useEffect(() =>{
        cleanInput();

        if(user){
            
            // Screen fields 
            setId(user.id);
            setFirstName(user.firstName);
            setLastName(user.lastName);
            setEmail(user.email);
            setBirthday(user.birthday);     
            setLogin(user.login);    
            setPassword(user.password);    
            setPhone(user.phone);    
            setCars(user.cars);     
        }
        
    },[user]);

    async function handleSubmit(e){        
        e.preventDefault();
        
        let newUser = {            
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "birthday": birthday,
            "login": login,
            "password": password,
            "phone": phone,
            "cars": cars,
        }

        // For edit user
        if(id){
            newUser['id'] = id;
        }

        await setUser(newUser);
        await saveUser(newUser);

    }

    function cleanInput(){ 
        setId('');               
        setFirstName('');
        setLastName('');
        setEmail('');
        setBirthday('');     
        setLogin('');    
        setPassword('');    
        setPhone('');         
        setCars([]);
    }

    async function saveUser(user) {

        const urlUsers = Share.baseUrl +'/users/';

        const method = user.id ? 'put' : 'post';
    
        try{
            const response = await ApiAxios[method](urlUsers, user);
            alert('Saved user');
            setRedirect(true);
        }catch(error){
            alert(error.message);
        }
              
    }

    function showCars(){
        if(user.cars != null && user.cars.length > 0){
            return (
                <React.Fragment>
                    <CarList userCars={user.cars}/>
                </React.Fragment>
            )
        }
    }

    return (
        <React.Fragment>

            {redirect ? <Redirect to='/users' /> : '' }

            <form onSubmit={handleSubmit}>

                <div className="p-3 mb-2 bg-light text-dark text-center">
                    <h3>Register User</h3>
                </div>

                <div className="form-row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="validationFirstName">First Name</label>
                        <input type="text" className="form-control" name="firstName"
                            id="validationFirstName" placeholder="First Name" required
                            value={firstName}
                            max-length="30"
                            onChange={e => { setFirstName(e.target.value); }} />
                    </div>

                    <div className="col-md-6 mb-3">
                        <label htmlFor="validationLastName">Last Name</label>
                        <input type="text" className="form-control" name="lastName"
                            id="validationLastName" placeholder="Last Name" required
                            value={lastName}
                            max-length="30"
                            onChange={e => { setLastName(e.target.value); }} />
                    </div>
                </div>

                <div className="form-row">
                    <div className="col-md-9 mb-3">
                        <label htmlFor="validationEmail">Email</label>
                        <input type="email" className="form-control" name="email"
                            id="validationModel" placeholder="Email" required
                            value={email}
                            max-length="30"
                            onChange={e => { setEmail(e.target.value); }} />
                    </div>

                    <div className="col-md-2 mb-2">
                        <label htmlFor="validationBirthday">Birthday</label>
                        <div className='input-group date' id='datetimepicker1'>
                            <DatePicker className="form-control" name="startDate"
                                placeholder="Birthday"
                                dateFormat="dd/MM/yyyy"
                                selected={birthday}
                                onChange={e => { setBirthday(e.target.value); }} />                            
                        </div>
                    </div>

                </div>

                <div className="form-row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="validationLogin">Login</label>
                        <input type="text" className="form-control" name="login"
                            id="validationModel" placeholder="Login" required
                            value={login}
                            max-length="30"
                            onChange={e => { setLogin(e.target.value); }} />
                    </div>

                    <div className="col-md-6 mb-3">
                        <label htmlFor="validationBirthday">Password</label>                        
                        <input type="password" className="form-control" name="birthday"
                            id="validationPassword" placeholder="Password" required
                            value={password}
                            max-length="8"
                            onChange={e => { setPassword(e.target.value); }} />
                    </div>
                </div>

                <div className="form-row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="validationPhone">Phone</label>
                        <input type="text" className="form-control" name="phone"
                            id="validationPhone" placeholder="Phone" 
                            value={phone}
                            max-length="15"
                            onChange={e => { setPhone(e.target.value); }} />
                    </div>
                   
                </div>

                <div className="p-3 mb-2 bg-light text-dark text-center">
                    <h3>Cars</h3>
                </div>

              {/* <CarList userCars={user.cars}/> */}
              {showCars()}

                <div>
                    <button className="btn btn-primary" type="submit" className="btn-primary">
                        Salvar
                    </button>
                </div>

            </form>

        </React.Fragment>
    )

}