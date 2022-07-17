import React from "react"

import { TemplateForm, Field } from './TemplateForm'
import { useState } from 'react';

const axios = require('axios').default;

export const TemplateFieldsList = () => {

    const [fields, setFields] = useState([]);

    const generate = async () => {
        let resp = await fetch('restPost.json')
        var json = await resp.json();

        axios.post('http://localhost:8080/tempalate/rest', json)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            })
    }

    return (
        <div>
            <ul>
                {
                    fields.map((field, index) => (
                        <li>
                            {field.type}  {field.name}
                            <button onClick={() => setFields(fields.filter((field, i) => i !== index))}></button>
                        </li>
                    ))
                }
            </ul>
            <TemplateForm addField={(field) => setFields(fields.concat(field))} />

            <button onClick={generate}>generate</button>
        </div>
    )

}