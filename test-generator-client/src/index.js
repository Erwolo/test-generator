import { StrictMode, useEffect, useState } from "react";
import { createRoot } from "react-dom/client";
import "./static/style/output.css";
import React, { Component } from 'react';

import { Box } from "@mui/system";

import { TemplateForm } from "./TemplateForm";

const rootElement = document.getElementById("root");
const root = createRoot(rootElement);

root.render(
  <StrictMode>
    <Box className="w-9/12 h-full">
      <TemplateForm />
    </Box>
  </StrictMode>
);
