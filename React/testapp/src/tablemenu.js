import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import Switches from './navigation';
import EditIcon from '@material-ui/icons/Edit';


const CustomTableCell = withStyles(theme => ({
  head: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  body: {
    fontSize: 14,
  },
}))(TableCell);

const styles = theme => ({
  root: {
    width: '80%',
    marginTop: theme.spacing.unit * 2,
    marginLeft: '10%',
    overflowX: 'auto',
  },
  table: {
    minWidth: 600,
  },
  row: {
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.background.default,
    },
  },
});

let id = 0;
function createData(name, price, available, edit) {
  id += 1;
  return { id, name, price, available, edit };
}

const rows = [
  createData('Chicken curry', 40),
  createData('Veg curry', 30),
  createData('Egg curry', 30),
  createData('Curd', 10),
  createData('Plain rice', 20),
];

function CustomizedTable(props) {
  const { classes } = props;

  return (
    <Paper className={classes.root}>
      <Table className={classes.table}>
        <TableHead>
          <TableRow>
            <CustomTableCell>Items)</CustomTableCell>
            <CustomTableCell align="right">Price</CustomTableCell>
            <CustomTableCell align="right">Is available?</CustomTableCell>
            <CustomTableCell align="right">Edit</CustomTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map(row => {
            return (
              <TableRow className={classes.row} key={row.id}>
                <CustomTableCell component="th" scope="row">
                  {row.name}
                </CustomTableCell>
                <CustomTableCell align="right">{row.price}</CustomTableCell>
                <CustomTableCell align="right">
                  <Switches></Switches>
                </CustomTableCell>
                <CustomTableCell align="right">
                  
                <EditIcon></EditIcon>
                </CustomTableCell>
              </TableRow>
            );
          })}
        </TableBody>
      </Table>
    </Paper>
  );
}

CustomizedTable.propTypes = {
  classes: PropTypes.object.isRequired,
};

const TableMenucomp = withStyles(styles)(CustomizedTable);
export default TableMenucomp;