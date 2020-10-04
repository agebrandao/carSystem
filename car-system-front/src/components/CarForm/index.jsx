import React, { useState, useEffect } from 'react';
import { Redirect } from 'react-router'

import ApiAxios from '../../config/apiAxios';
import Share from '../../share';

export default function CarForm(props) {

    const [car, setCar] = useState('');

    const [id, setId] = useState('');    
    const [year, setYear] = useState(0);
    const [licensePlate, setLicensePlate] = useState('');
    const [model, setModel] = useState('');
    const [color, setColor] = useState('');

    const [redirect, setRedirect] = useState(false);

    useEffect(() =>{
        cleanInput();

        // For edit 
        if(props && props.location && props.location.car){

            const carEdit = {
                "id": props.location.car.id,
                "year": props.location.car.year,
                "licensePlate": props.location.car.licensePlate,
                "model": props.location.car.model,
                "color": props.location.car.color               
            }

            setCar(carEdit);         
        }

    },[]);

    useEffect(() =>{
        cleanInput();

        if(car){
            
            // Screen fields 
            setId(car.id);
            setYear(car.year);
            setLicensePlate(car.licensePlate);
            setModel(car.model);
            setColor(car.color);          
        }
        
    },[car]);

    async function handleSubmit(e){        
        e.preventDefault();
        
        let newCar = {
            "year": year,
            "licensePlate": licensePlate,            
            "model": model,
            "color": color
        }

        // For edit car
        if(id){
            newCar['id'] = id;
        }

        await setCar(newCar);
        await saveCar(newCar);

    }

    function cleanInput(){        
        setYear('');
        setLicensePlate('');;
        setModel('');;
        setColor('');
    }

    async function saveCar(car) {

        const urlCars = Share.baseUrl +'/cars';

        const method = car.id ? 'put' : 'post';    
        
        try{
            const response = await ApiAxios[method](urlCars, car);
            alert('Saved car');
            setRedirect(true);
        }catch(error){
            alert(error.message);
        }      
    }

    return (
        <React.Fragment>

            {redirect ? <Redirect to='/cars' /> : '' }

            <form onSubmit={handleSubmit}>

                <div className="p-3 mb-2 bg-light text-dark text-center">
                    <h3>Register Car</h3>
                </div>

                <div className="form-row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="validationYear">Year</label>
                        <input type="text" className="form-control" name="year"
                            id="validationYear" placeholder="Ex: 2020" required
                            value={year}
                            max-length="4"
                            onChange={e => { setYear(e.target.value); }} />
                    </div>

                    <div className="col-md-6 mb-3">
                        <label htmlFor="validationLicensePlate">License Plate</label>                        
                        <input type="text" className="form-control" name="licensePlate"
                            id="validationlicensePlate" placeholder="XXX-9999" required
                            value={licensePlate}
                            max-length="8"
                            onChange={e => { setLicensePlate(e.target.value); }} />
                    </div>
                </div>

                <div className="form-row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="validationYear">Model</label>
                        <input type="text" className="form-control" name="model"
                            id="validationModel" placeholder="Model" required
                            value={model}
                            max-length="15"
                            onChange={e => { setModel(e.target.value); }} />
                    </div>

                    <div className="col-md-6 mb-3">
                        <label htmlFor="validationColor">Color</label>                        
                        <input type="text" className="form-control" name="color"
                            id="validationColor" placeholder="Color" required
                            value={color}
                            max-length="15"
                            onChange={e => { setColor(e.target.value); }} />
                    </div>
                </div>

               
                <div>
                    <button className="btn btn-primary" type="submit" className="btn-primary">
                        Salvar
                    </button>
                </div>

            </form>

        </React.Fragment>
    )

}