// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';
th:inline="javascript"
//
var dates = document.getElementById("dates").value;
console.log(dates);
var data =[];
var dates1 = dates.split(",");
for(i=0;i<dates.length;i++)
{
	var mySQLDate = dates[i];
    data.push(new Date(Date.parse(mySQLDate.replace(/-/g, '/'))).toLocaleString('DD-MMM')) ;
}
var count = document.getElementById("count").value;
console.log(count);
console.log(data)

// Area Chart Example
var ctx = document.getElementById("myAreaChart");
//var list = /*[[${whatsap.pclick}]] */ "test1";
var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: [data],
    datasets: [{
      label: "Sessions",
      lineTension: 0.3,
      backgroundColor: "rgba(2,117,216,0.2)",
      borderColor: "rgba(2,117,216,1)",
      pointRadius: 5,
      pointBackgroundColor: "rgba(2,117,216,1)",
      pointBorderColor: "rgba(255,255,255,0.8)",
      pointHoverRadius: 5,
      pointHoverBackgroundColor: "rgba(2,117,216,1)",
      pointHitRadius: 50,
      pointBorderWidth: 2,
       data: [count],
     // data: [10000, 30162, 26263, 18394, 18287, 28682, 31274, 33259, 25849, 24159, 32651, 31984, 38451],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'date'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 7
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 40000,
          maxTicksLimit: 5
        },
        gridLines: {
          color: "rgba(0, 0, 0, .125)",
        }
      }],
    },
    legend: {
      display: false
    }
  }
});
