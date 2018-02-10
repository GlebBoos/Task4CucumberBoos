#language: ru

Функционал: Сбербанк страхование

  Сценарий: Заявка на страхование

    Когда Открывается пункт меню: "Застраховать себя  и имущество"
    Тогда Запускается вид страхования: "Страхование путешественников"

    Когда Вид страхования: "Страхование путешественников"
    И Проверка на ошибки заголовка "Страхование путешественников"

    Когда Проверка на ошибки заголовка "Страхование путешественников"
    Тогда Переход на новую вкладку

    Когда Выбран минимальный пакет страхования: "Минимальная"
    Тогда Переход к этапу ввода данных по заявке

    Когда Ввод данных:
      |фамилия застрахованного|Boos|
      |имя застрахованного|Gleb|
      |дата рождения застрахованного|17.09.1994|
      |фамилия|Иванов|
      |имя|Иван|
      |отчество|Иванович|
      |день рождения|17.09.1994|
      |серия паспорта|1111|
      |номер паспорта|111111|
      |дата выдачи||
      |место выдачи|Москва|
      |телефон|(985) 683-3950|
      |email|gboos@aplana.com|
      |emailValid|gboos@aplana.com|
    Тогда Проверка данных:
      |фамилия застрахованного|Boos|
      |имя застрахованного|Gleb|
      |дата рождения застрахованного|17.09.1994|
      |фамилия|Иванов|
      |имя|Иван|
      |отчество|Иванович|
      |день рождения|17.09.1994|
      |серия паспорта|1111|
      |номер паспорта|111111|
      |дата выдачи||
      |место выдачи|Москва|
      |телефон|(985) 683-3950|
      |email|gboos@aplana.com|
      |emailValid|gboos@aplana.com|

    Когда Оформление заявки
    Тогда Вывод сообщения об ошибке: "Заполнены не все обязательные поля"