document.getElementById('name-button').addEventListener('click', function() {
    window.scrollTo({ top: 0, behavior: 'smooth' }); // Прокручивает страницу вверх плавно
    setTimeout(function() {
        location.reload(); // Обновляет страницу через 500 мс после прокрутки
    }, 500);
});

document.getElementById('notifications').addEventListener('click', function() {
    var panel = document.getElementById('notification-panel');
    if (panel.style.display === 'none' || panel.style.display === '') {
        panel.style.display = 'block'; // Показываем панель уведомлений
    } else {
        panel.style.display = 'none'; // Скрываем панель уведомлений
    }
});


