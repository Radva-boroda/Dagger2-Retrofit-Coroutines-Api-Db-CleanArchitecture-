package dev.ronnie.imageloaderdagger2.dataa.repository

// Repository //
//Місце де підтримуються і обробляють дані

// 1 //
//Pager
//Основна точка входу в пейджинг; конструктор для реактивного потоку PagingData.
//Кожен з них PagingDataпредставляє знімок резервних даних, розбитих на сторінки.
//               Оновлення базового набору даних має бути представлено новим екземпляром PagingData.
//PagingSource.invalidateі виклики AsyncPagingDataDiffer.refreshабо PagingDataAdapter. refreshсповіщатимуть
//               Pagerпро те, що резервний набір даних оновлено, і буде створено нову пару PagingData/
//               для представлення оновленого знімка.PagingSource
//PagingDataможна трансформувати, щоб змінити дані під час завантаження, і представити у вигляді
//               RecyclerViewvia AsyncPagingDataDifferабо PagingDataAdapter.
//Підтримка LiveData доступна як властивість розширення,
//              що надається артефактом androidx.paging:paging-runtime.
//Підтримка RxJava доступна як властивості розширення, надані артефактом androidx.paging:paging-rxjava2.

// 2 //
//PagingConfig
//Об’єкт, який використовується для налаштування поведінки завантаження в межах Pager,
//                                      оскільки він завантажує вміст із PagingSource.