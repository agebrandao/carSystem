import React from 'react'
import imageHome from '../../assets/screenHome.png';
//import imageHomeMobile from '../../../assets/screenHome-mobile.png'

export default props =>

    <React.Fragment>    
        
        <div className="card bg-dark text-white">
            <img src={imageHome} className="card-img d-none d-sm-block" alt="Responsive image"/>
            {/* <img src={imageHomeMobile} className="card-img d-block d-sm-none" alt="Responsive image"/> */}
        </div>

    </React.Fragment>





