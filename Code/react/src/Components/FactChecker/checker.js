import React from "react";

class FactChecker extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			factStatus: 'Verify',
			factString: 'Enter your Text to verify',
		};
	}

	CheckFact = (event) => {
		event.preventDefault();

	    fetch(`/CheckFact?fact=${encodeURIComponent(this.state.factString)}`, {
	      "method": "GET"
	    })
	    .then(response => response.text())
	    .then(response => {
	    	console.log(response);
			this.setState({factStatus: response});
	    })
	    .catch(err => {
	      console.log(err);
	    });
	}
	
	factTextChangeHandler = (event) => {
		this.setState({factString: event.target.value});
	}

	render() {
		return (
			<div>
			<form onSubmit={this.CheckFact} >
              <input
                type="text"
                onChange={this.factTextChangeHandler}
              />
              <input type='submit' value="verify" />
	        </form>
	        <strong> {this.state.factStatus} </strong>
			</div>
		)
	}
}
export default FactChecker;