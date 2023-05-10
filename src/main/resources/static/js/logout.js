document.addEventListener('DOMContentLoaded', function () {
  var logoutBtn = document.getElementById('logoutBtn');

  logoutBtn.addEventListener('click', function () {
    alert('ログアウトしました。');
    window.location.href = '/login'; // ログインページへのリダイレクトなどの処理を行う場合はここで指定します
  });
});
