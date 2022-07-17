// import React, { useState } from "react";
import * as React from 'react';
import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import List from '@mui/material/List';
import ListSubheader from '@mui/material/List';
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

export const TemplatesList = (props) => {
  return (
    <List className="h-full">
      <ListSubheader>{'Templates'}</ListSubheader>
      {props.list.map((template, i) => <Template template={template} remove={props.removeTemplate} />)}
    </List>
  )
}

const Template = (props) => {
  return (
    <ListItem 
    // key={props.template.id}
      secondaryAction={
        <div>
          <IconButton edge="end" aria-label="delete" onClick={() => props.remove(props.template.name)}>
            <DeleteIcon />
          </IconButton>
          <IconButton edge="end" aria-label="delete" onClick={() => props.remove(props.template.name)}>
            <EditIcon />
          </IconButton>
        </div>
      }
    >
      <ListItemAvatar>
        <Avatar>
          <FolderIcon />
        </Avatar>
      </ListItemAvatar>
      <ListItemText
        primary={props.template.name}
        // secondary={'Secondary text'}
      />
    </ListItem>
  )
}

