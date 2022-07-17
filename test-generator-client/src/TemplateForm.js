import { StrictMode, useEffect, useState } from "react";
import React, { Component } from 'react';
import ReactDom from "react-dom";

import { TemplatesList } from "./TemplatesList";
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import InputLabel from '@mui/material/InputLabel';

import { TemplateDialog } from "./TemplateDialog";

const axios = require('axios').default;

export class Field {
  constructor(type, name) {
    this.type = type
    this.name = name
  }
}

class TemplateGeneratorJson {
  constructor(group, artifact, name, description, packageName, templates){
    this.group = group;
    this.artifact = artifact;
    this.name = name;
    this.description = description;
    this.packageName = packageName;
    this.templates = templates;
  }
}

export const TemplateForm = () => {
  const [open, setOpen] = useState(false);
  const [list, setList] = useState([]);
  const [projectGroup, setProjectGroup] = useState("com.group");
  const [projectArtifact, setProjectArtifact] = useState("demo");
  const [projectName, setProjectName] = useState("demo");
  const [projectDescription, setProjectDescription] = useState("Demo for project for Spring");
  const [projectPackageName, setProjectPackageName] = useState("com.example.demo");

  function addTemplate(template) {
    setList(list.concat(template));
  }

  function removeTemplate(index) {
    console.log(index)
    const newList = list.filter((item) => list.indexOf(item) !== index);
    setList(newList);
  }

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleAddAndClose = (template) => {
    setOpen(false);
    addTemplate(template);
  };

  const generate = async () => {
    let resp = await fetch('restPost.json')
    var json = await resp.json();

    // const object = new TemplateGeneratorJson(projectGroup, projectArtifact, projectName, projectDescription, projectPackageName, list);
    // const json = JSON.stringify(list)
    // console.log(json)
    
    axios.post('http://localhost:8080/tempalate/rest', json)
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        })
  }

const handleSubmit = (e) => {

  const json = new TemplateGeneratorJson(projectGroup, projectArtifact, projectName, projectDescription, projectPackageName, list);

  console.log(json)
  console.log(JSON.stringify(json))
}

  return (
    <div className="w-full h-5/6 flex">
      <div className="w-1/2 p-8">
        <p className="pb-4">Project Metadata</p>
        <div className="grid grid-cols-2 gap-5 items-center">
            <InputLabel htmlFor="project-group">Group</InputLabel>
            <TextField id="project-group" value={projectGroup} onChange={e => setProjectGroup(e.target.value)}/>

            <InputLabel htmlFor="project-artifact">Artifact</InputLabel>
            <TextField id="project-artifact" value={projectArtifact} onChange={e => setProjectArtifact(e.target.value)}/>

            <InputLabel htmlFor="project-name">Name</InputLabel>
            <TextField id="project-name" value={projectName} onChange={e => setProjectName(e.target.value)}/>

            <InputLabel htmlFor="project-description">Description</InputLabel>
            <TextField id="project-description" value={projectDescription} onChange={e => setProjectDescription(e.target.value)}/>

            <InputLabel htmlFor="project-package-name">PackageName</InputLabel>
            <TextField id="project-package-name" value={projectPackageName} onChange={e => setProjectPackageName(e.target.value)}/>
        </div>
      </div>
      <div className="bg-gray-100 flex-auto p-8">
        <TemplatesList list={[1,2,3,4]} removeTemplate={removeTemplate} />
        <Button onClick={handleClickOpen}>Add</Button>
        <Button onClick={generate} className="">Generate</Button>
      </div>
      <TemplateDialog open={open} handleClose={handleClose} handleAddAndClose={handleAddAndClose} />
    </div>
  )
}
