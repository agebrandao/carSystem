import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom'

import ApiAxios from '../../config/apiAxios';
import Share  from '../../share';

export default function UserList() {

    const [user, setUser] = useState('');

    const [users, setUsers] = useState([]);

    useEffect(() =>{
        getUserList('');
    },[]);

    useEffect(() => {
        setUsers([...users, user]);
    }, [user]);


    async function getUserList() {

        const urlUsers = Share.baseUrl +'/users';

        let url = urlUsers;
        
        await ApiAxios.get(url)
            .then(res => {
               
                
                    setUsers(res.data);
                                  
            }).catch(function (error) {
                alert(error.message);
        })
    }

    async function removeUser(user) {

        const urlUsers = Share.baseUrl +'/users';

        if (user.id && user.id > 0) {

            let url = urlUsers +'/'+ user.id;

            await ApiAxios.delete(url)
            .then(res => {
                setUsers(users.filter(userItem => userItem != user)); 
            }).catch(function (error) {
                alert(error.message);
            });
        }else{
            alert("Select a user");
        }
    }

    function rows() {

        const rows = [];

        if (users) {
            users.map(userItem => {
                rows.push(<tr key={userItem.id}>
                    {
                        <React.Fragment>
                            <td >{userItem.id}</td>
                            <td >{userItem.firstName}</td>
                            <td>{userItem.lastName}</td>
                            <td>{userItem.email}</td>
                            <td>{userItem.birthday}</td>    
                            <td>{userItem.login}</td>                           
                            <td>{userItem.phone}</td>                                             
                            <td >
                                <Link to={{
                                    pathname: '/user/:user',
                                    user: userItem
                                }}>
                                    <i className="fa fa-pencil"></i>
                                </Link>

                                &nbsp; &nbsp;

                                <Link to={{}}
                                    onClick={() => removeUser(userItem)}>
                                    <i className="fa fa-trash"></i>
                                </Link>
                            </td>
                        </React.Fragment>
                    }
                </tr>)
            });
        }
        return rows
    }

    return (
        <React.Fragment>

            <div className="bg-light">
                <div className="p-3 mb-2 bg-light text-dark text-center">
                    <h3 >List of Users</h3>
                </div>

                <div className="d-flex flex-row-reverse px-md-3">
                    <Link to="/user">
                        <button type="button" className="btn btn-info rounded-circle"><i className="fa fa-plus"></i></button>
                    </Link>
                </div>
            </div>           

            <table className="table table-sm ">
                <thead>
                    <tr>
                        {/* <th scope="col">#</th> */}
                        <th scope="col">ID</th>
                        <th scope="col"className="d-none d-sm-block">FirstName</th>
                        <th scope="col">LastName</th>                        
                        <th scope="col">Email</th>
                        <th scope="col">Birthday</th>           
                        <th scope="col">login</th>           
                        <th scope="col">phone</th>                                                      
                        <th width="5%" scope="col ">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {rows()}
                </tbody>
            </table>
        </React.Fragment>
    )
}
