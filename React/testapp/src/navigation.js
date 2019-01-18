import React from 'react';
import Switch from '@material-ui/core/Switch';

class Switches extends React.Component {
  state = {
    checkedA: true,
  };

  handleChange = name => event => {
    this.setState({ [name]: event.target.checked });
  };

  render() {
    return (
      <div>
        <Switch
          checked={this.state.checkedA}
          onChange={this.handleChange('checkedA')}
          value="checkedA"
        />
      </div>
    );
  }
}

export default Switches;