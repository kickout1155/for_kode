package com.example.forkode

//
//        то как я это видел отличается от того что я сделал, по времени не успел бы сделать
//        1) митап мне отказал в выдаче ключа для использования апи
//        2) при проверка билетов, была идея сделать реактивно(т.е. viewmodel была бы подписана но
//        "бизнес логику" по которой прокидывала бы количество и ошибки)
//        3) при выводе погоды я видел это через отдельные фрагменты, т.е. в поле с recycler должен
//        быть фрагмент с recycler и надо было отбрабатывать стек чтобы не плодить фрагменты
//        4) с дагером пока не работал поэтому все в конструкторы))))
//        5) сразу скажу анимации бы пока не реализовал знаю что делаются через shared но не углублялся в них
//        6) если успею, набросаю логику на поиск города, вкратце надо установить debounce чтобы постоянно не бегать в сеть
//        при каждом вводе символа, т.е. я бы так сделал.
//        7) выбор с ограничением минимальной даты, была идея это делать все это сделать во viewModel
//        но отказался, и на мой взгляд, надо делать в DatePickerTicket через методы (что то наподобие
//        установить минимальную дату)
//        8) чуть не забыл, по индикатору загрузки использовал бы swipeRefreshLayout (это касается детализации погоды)
//        В остальном особых проблем не вижу, да UI не мой конек =( (фрагмент с детализацией погоды)
//        Очень надеюсь что мысль удалось донести
//        И просьба дать фидбек по реализации






