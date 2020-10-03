import React, { useContext } from 'react';

import { Link } from 'react-router-dom'

const Header = () => {

    return (
        <React.Fragment>
            <nav className="navbar sticky-top navbar-expand-lg navbar-light bg-dark" >
                <div className="navbar-nav">
                    <Link className="nav-item nav-link text-white" to="/">
                        <i className="fa fa-home fa-2x"></i>
                    </Link>
                    <Link className="nav-item nav-link text-white" to="/users">
                        <h5>
                            Users
                        </h5>
                    </Link>
                    <Link className="nav-item nav-link text-white" to="/cars">
                        <h5>
                            Cars
                        </h5>
                    </Link>
                </div>
            </nav>
        </React.Fragment>
    )
}

export default Header;