import {useState, useEffect} from "react"
import axios from 'axios';

const BtnCount = ({id}) => {
    const [count, setCount] = useState(0);

    useEffect(() => {
       axios({
           method: 'GET',
           url :`http://localhost:8080/api/counter/count/${id}`,
           headers: {
            'Content-Type': 'application/json',
            'authentication': 'YWRtaW46YWRtaW4='
           },
       }).then((res)=>{
        const data = res.data
        setCount(data.count);
    }).catch(err=>{
        console.error(err);
    })
    }, [])

    const handleClick = () => {
        axios({
            method: 'POST',
            url :'http://localhost:8080/api/counter/click',
            headers: {
                'Content-Type': 'application/json', 
                'authentication': 'YWRtaW46YWRtaW4='
            },
            data: JSON.stringify({id: id})
        }).then((res)=>{
            const data = res.data
            setCount(data.count)
        }).catch(err=>{
            console.error(err);
        })
    }

    return (
        <div className="btn__container">
            <label className="btn__label" htmlFor={id}>{count}</label>
            <button type="button" id={id} className="btn" onClick={handleClick}>Just some button</button>
        </div>
    )
}

export default BtnCount
