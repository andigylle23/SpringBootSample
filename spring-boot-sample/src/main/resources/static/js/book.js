//検索機能、カラム[1]にの対応するタイトルだけ）
function searchFunction() {
  	var input, filter, table, tr, td, i, txtValue;
  		// 検索の入力ID
  		input = document.getElementById("searchInput");
  		filter = input.value.toUpperCase();
  		// テーブル名
  		table = document.getElementById("book-table");
  		tr = table.getElementsByTagName("tr");

  		for (i = 0; i < tr.length; i++) {
  			//　td(カラムの対応する）[1]=タイトル
    		td = tr[i].getElementsByTagName("td")[1];
    	if (td) {
      		txtValue = td.textContent || td.innerText;
      			if (txtValue.toUpperCase().indexOf(filter) > -1) {
      				tr[i].style.display = "";
      			} else {
      				tr[i].style.display = "none";
      		}
    	}       
  	}
}
