import React, { useContext } from 'react';
import './style.css';

import Share  from '../../share';

const Login = () =>{


    async function handleSubmit(e){        
        e.preventDefault();
        
        Share.hideMenu = false;
    }   
   
    return(
        <div className="component">
 
            <form className="form" onSubmit={handleSubmit}>
               
                <div className="div">
                    <label className="label" htmlFor="">E-MAIL</label>
                    <input className="input" type="text"/>
                </div> 

                <div className="div">
                    <label className="label" htmlFor="">SENHA</label>
                    <input className="input" type="password"/>
                </div>      

                <button  className="button" type="submit" >Entrar no Sistema</button>     
            </form>
        </div>
    )
}

export default Login;