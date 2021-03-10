import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import { Route, BrowserRouter as Router, Switch } from "react-router-dom";
import App from './App';
import * as serviceWorker from './serviceWorker';
import Header from "./Components/Header/header";
import Footer from "./Components/Footer/footer";

const routing = (
  <Router>
    <div>
      <Header />
      <hr />
      <Switch>
        <Route exact path="/" component={App} />
      </Switch>
      <Footer />
    </div>
  </Router>
);


ReactDOM.render(routing, document.getElementById("root"));
