import React, { useState, useEffect } from 'react';
import { Redirect } from 'react-router'
import { Link } from 'react-router-dom'

import ApiAxios from '../../config/apiAxios';
import Share  from '../../share';

export default function CarList(props) {

    const [car, setCar] = useState('');

    const [cars, setCars] = useState([]);

    const [redirect, setRedirect] = useState(false);

    useEffect(() =>{

        // User cars list
        if(props &&  props.userCars){
            const userCars = props.userCars;
            userCars.map(carItem => carItem != null ? setCar(carItem) : '')                          
        }else{        
            //all cars
            getCarList('');
        }
                
    },[]);

    useEffect(() => {
        if(car != ''){
            setCars([...cars, car]);
        }
    }, [car]);    

    async function getCarList() {
         
        const urlCars = Share.baseUrl +'/cars';

        let url = urlCars;
        
        try{
            const response = await ApiAxios.get(url);
            setCars(response.data);
        }catch(error){
            if(error.status == 403){
                alert("Access Denied");
                setRedirect(true);
            }else{
                alert(error.message);
            }
            
        }    
    }

    async function removeCar(car) {

        const urlCars = Share.baseUrl +'/cars';

        if (car.id && car.id > 0) {

            let url = urlCars +'/'+ car.id;

            try{
                const response = await ApiAxios.delete(url);   
                alert(response.data);
                setCars(cars.filter(carItem => carItem != car));  
            }catch(error){
                alert(error.message);
            }

        }else{
            alert("Select a car");
        }
    }

    function rows() {

        const rows = [];

        if (cars) {
            cars.map(carItem => {
                rows.push(<tr key={carItem.id}>
                    {
                        <React.Fragment>
                            <td >{carItem.id}</td>
                            <td >{carItem.year}</td>
                            <td>{carItem.licensePlate}</td>
                            <td>{carItem.model}</td>
                            <td>{carItem.color}</td>                            
                            <td >
                                <Link to={{
                                    pathname: '/car/:car',
                                    car: carItem
                                }}>
                                    <i className="fa fa-pencil"></i>
                                </Link>

                                &nbsp; &nbsp;

                                <Link to={{}}
                                    onClick={() => removeCar(carItem)}>
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

            {redirect ? <Redirect to='/login' /> : '' }

            <div className="bg-light">
                <div className="p-3 mb-2 bg-light text-dark text-center">
                    <h3 >List of Cars</h3>
                </div>

                <div className="d-flex flex-row-reverse px-md-3">
                    <Link to="/car">
                        <button type="button" className="btn btn-info rounded-circle"><i className="fa fa-plus"></i></button>
                    </Link>
                </div>
            </div>           

            <table className="table table-sm ">
                <thead>
                    <tr>
                        {/* <th scope="col">#</th> */}
                        <th scope="col">ID</th>
                        <th scope="col">Year</th>
                        <th scope="col" className="d-none d-sm-block">LicensePlate</th>                        
                        <th scope="col">Model</th>
                        <th scope="col">Color</th>                     
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
