
import { StrictMode, useEffect, useState } from "react";
import { createRoot } from "react-dom/client";

import React, { Component } from 'react';

import List from '@mui/material/List';
import ListSubheader from '@mui/material/List';
import { TemplateConfigurator } from "./TemplateConfigurator";
import { TemplatesList } from "./TemplatesList";
import { Box } from "@mui/system";
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import { responsiveFontSizes } from "@mui/material";
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import FolderIcon from '@mui/icons-material/Folder';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import InputLabel from '@mui/material/InputLabel';

const axios = require('axios').default;

class Template {
    constructor(title, description, type, properties, required) {
        this.title = title
        this.description = description
        this.type = type
        this.properties = properties
        this.required = required
    }
}

export const TemplateDialog = (props) => {
    const [dbTemplates, setDbTemplates] = useState([]);
    const [template, setTemplate] = useState('');

    const [form, setForm] = useState(null);

    const response = async () => {
        await axios.get('http://localhost:8080/tempalates')
            .then(response => {
                response.data.forEach((app) => console.log(app))
                setDbTemplates(response.data)
            })
    }

    useEffect(() => {
        // response()
    }, [])

    useEffect(() => {
        console.log(form)
    }, [form])

    const handleSelectTemplate = (template) => {
        setTemplate(template)
        console.log(template)
        generateForm();
    }

    const generateForm = async () => {
        var json = {
            "$schema": "https://json-schema.org/draft/2020-12/schema",
            "$id": "https://example.com/product.schema.json",
            "title": "Product",
            "description": "A product from Acme's catalog",
            "type": "object",
            "properties": {
                "productId": {
                    "description": "The unique identifier for a product",
                    "type": "integer"
                },
                "productName": {
                    "description": "Name of the product",
                    "type": "string"
                },
                "price": {
                    "description": "The price of the product",
                    "type": "number",
                    "exclusiveMinimum": 0
                },
                "asddas": {
                    "description": "The unique identifier for a product",
                    "type": "integer"
                },
                "produdsadsactName": {
                    "description": "Name of the product",
                    "type": "string"
                },
                "pridasdasdce": {
                    "description": "The price of the product",
                    "type": "number",
                    "exclusiveMinimum": 0
                },
                "produasdasctId": {
                    "description": "The unique identifier for a product",
                    "type": "integer"
                },
                "prodasdasdasductName": {
                    "description": "Name of the product",
                    "type": "string"
                },
                "prissce": {
                    "description": "The price of the product",
                    "type": "number",
                    "exclusiveMinimum": 0
                }
            },
            "required": ["productId", "productName", "price"]
        }

        console.log(json.properties)
        var template = Object.assign(new Template, json)
        //   var list = Object.keys(json.properties).map(key => key)

        //   console.log(list)
        setForm(() => template)

    }


    return (
        <Dialog className="backdrop-blur-sm" PaperProps={{
            style: {
                minHeight: '80%',
                minWidth: '80%',
            }
        }} open={props.open} onClose={props.handleClose}>
            <DialogTitle onClick={generateForm}>{template === '' ? "Templates" : template.name}</DialogTitle>
            <DialogContent className="flex h-11/12 gap-x-10">
                <div className="w-3/4 grid grid-cols-2 gap-5 items-center" style={{gridAutoRows: 'minmax(min-content, max-content)'}}>
                    {
                        form ? 
                        Object.keys(form.properties).map(key => 
                                <>
                                    <InputLabel htmlFor={"template-"}>{key}</InputLabel>
                                    <TextField id="project-group" value={form.properties[key].description} />
                                </>
                            )
                        : <p>Select template</p>
                    } 
                </div>
                <div className="w-full h-full">
                    <List>
                        {[1,2,4].map((template, i) =>
                            <ListItem
                                onClick={() => handleSelectTemplate(template)}
                            // key={props.template.id}
                            >
                                <ListItemAvatar>
                                    <Avatar>
                                        <FolderIcon />
                                    </Avatar>
                                </ListItemAvatar>
                                <ListItemText
                                    primary={template.name}
                                // secondary={'Secondary text'}
                                />
                            </ListItem>
                        )}
                    </List>
                </div>
            </DialogContent>
            <DialogActions>
                <Button onClick={() => props.handleAddAndClose(template)}>Add</Button>
                <Button onClick={props.handleClose}>Cancel</Button>
            </DialogActions>
        </Dialog >
    )
}
