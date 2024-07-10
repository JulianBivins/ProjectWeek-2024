
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