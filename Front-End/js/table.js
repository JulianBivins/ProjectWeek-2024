
// Tabelle Such Funktionalität
document.getElementById('tableSearch').addEventListener('input', function () {
  const filter = this.value.toUpperCase();
  const rows = document.querySelectorAll('#tableBody tr');
  
  rows.forEach(row => {
    const text = row.textContent || row.innerText;
    if (text.toUpperCase().indexOf(filter) > -1) {
      row.style.display = '';
    } else {
      row.style.display = 'none';
    }
  });
});


// Tabelle Dynamik entries
const jsonData = [
  {
    "teil": "a",
    "option": "1",
    "jahr": "2025",
    "kursArt": "GK",
    "fach": "Java",
    "uuid": "01223032",
    "lösung": "false"
  },
  {
    "teil": "b",
    "option": "2",
    "jahr": "2024",
    "kursArt": "LK",
    "fach": "Python",
    "lösung": "true"
  }
]; 
function generateTable(data) {
  const tableBody = document.getElementById('table-body');

  data.forEach(item => {
    const tr = document.createElement('tr');

    tr.innerHTML = `
      <td>${item.jahr}</td>
      <td>${item.teil}${item.option}</td>
      <td>${item.fach}</td>
      <td>${item.kursArt}</td>
      <td>${item.lösung}</td>
      <td><a href="#">Download</a></td>
    `;

    tableBody.appendChild(tr);
  });
}

// Generate table on page load
document.addEventListener('DOMContentLoaded', () => generateTable(jsonData));