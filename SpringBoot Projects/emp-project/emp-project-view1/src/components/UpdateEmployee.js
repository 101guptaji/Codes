import React, {useEffect, useState } from 'react'
import {useNavigate, useParams} from 'react-router-dom'
import EmployeeService from '../services/EmployeeService';

const UpdateEmployee = () => {
    //initialization
    const {id} = useParams();

    const [employee, setEmployee] = useState({
        id : id,
        name:"",
        phoneNo:"",
        email:""
    });

    useEffect(() =>{
        const fetchData = async () =>{
            try{
                const response = await EmployeeService.getEmployeeById(employee.id);
                setEmployee(response.data);
            }catch(error){
                console.log(error);
            }
        };
        fetchData();
    }, []);

    const handleChange = (e) =>{
        const value = e.target.value;
        setEmployee({...employee, [e.target.name]: value})
    }

    const updateEmployee = (e) =>{
        e.preventDefault();
        EmployeeService.updateEmployee(employee,id)
        .then((response) => {
            console.log("saved ",response);
            navigate("/")
        })
        .catch((error) => {
            console.log(error);
        })
    }

    const navigate = useNavigate();
    return (
    <div className='max-w-xl mx-40 bg-slate-800 my-20 rounded shadow py-4 px-8'>
        <div className='text-3xl tracking-wider font-bold text-center py-4 px-8'>
            <p>Edit Employee🧑🏼‍💻</p>
        </div>

        <div className='mx-10 my-2'>
        <input 
            type='text'
            name="name"
            value={employee.name}
            onChange={(e)=> handleChange(e)}
            className="w-full py-2 my-4 text-slate-800" placeholder='Name'></input>
           
            <input
            type='number'
            name='phoneNo'
            value={employee.phoneNo}
            onChange={(e) => handleChange(e)}
            className="w-full py-2 my-4 text-slate-800" placeholder='Phone'></input>
            
            <input 
            type='email'
            name='email'
            value={employee.email}
            onChange={(e) => handleChange(e)}
            className="w-full py-2 my-4 text-slate-800" placeholder='Email'></input>
        </div>

        <div className='flex my-4 space-x-4 px-20'>
            <button
            onClick={updateEmployee}
            className='bg-green-400 hover:bg-green-700 py-2 px-6 rounded'> Update </button>
            <button 
            onClick={() => navigate("/")}
            className='bg-red-400 hover:bg-red-700 py-2 px-6 rounded'>  Cancel </button>
        </div>
    </div>
    )
}

export default UpdateEmployee