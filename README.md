# studentDatabase

Это мой тестовый проект StudentDatabase - набор сервисов для управления сущностями: студент, группа, роль студента (отличник, активист и так далее).

Сущности "студент" и "группа" связаны отношением "один ко многим", а сущности "студент" и "роль" отношением "многие ко многим".
Для работы с сущностями используетс фреймворк Hibernate, для хранения таблиц - СУБД PostrgeSQl.
Реализованы методы вставки, чтения, редактирования, удаления, поиска, также реализовано получение списка студентов, которые 
претендуют на повышенную стипендию. 
Методы сервисов покрыты тестами JUnit 5. 
В корне проекта расположена схема базы данных (.png), код развертки на SQL для быстрого воссоздания базы и файл .pgerd для открытия непосредственно в pgAdmin.