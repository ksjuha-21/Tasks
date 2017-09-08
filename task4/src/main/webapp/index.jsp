<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>

    <title>Index JSP</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form id="form" name="form" method="post" action="#">
    text for example: "использование гугла в изучении вопросов
    поощряется."<br/>
    Input text:<br>
    <input name="name" type="text" id="name" value="использование гугла в изучении вопросов поощряется." size="50" /><br>
    Result translit:<br>
    <input name="alias" type="text" id="alias" size="50"/><br/>
    Result обратный translit:<br>
    <input name="al" type="text" id="al" size="50"/>
</form>
<div id="result"></div>

<script>

    function translit(){
// Символ, на который будут заменяться все спецсимволы
        var space = '';
// Берем значение из нужного поля и переводим в нижний регистр
        var text = $('#name').val().toLowerCase();

// Массив для транслитерации
        var transl = {
            'а': 'a', 'б': 'b', 'в': 'v', 'г': 'g', 'д': 'd', 'е': 'e', 'ё': 'e', 'ж': 'zh',
            'з': 'z', 'и': 'i', 'й': 'j', 'к': 'k', 'л': 'l', 'м': 'm', 'н': 'n',
            'о': 'o', 'п': 'p', 'р': 'r','с': 's', 'т': 't', 'у': 'u', 'ф': 'f', 'х': 'h',
            'ц': 'c', 'ч': 'ch', 'ш': 'sh', 'щ': 'sh','ъ': space, 'ы': 'y', 'ь': '\'', 'э': 'e', 'ю': 'yu', 'я': 'ya'

        }

        var result = '';

        for(i=0; i < text.length; i++) {
            // Если символ найден в массиве то меняем его
            if(transl[text[i]] != undefined) {

                result += transl[text[i]];


            }
            // Если нет, то оставляем так как есть
            else {
                result += text[i];

            }
        }

        result = TrimStr(result);

// Выводим результат
        $('#alias').val(result);


    }

    // Выполняем транслитерацию при вводе текста в поле
    $(function(){
        $('#name').keyup(function(){
            translit();
            return false;
        });
    });



    function translit1(){
// Символ, на который будут заменяться все спецсимволы
        var space = ' ';
// Берем значение из нужного поля и переводим в нижний регистр
        var text = $('#name').val().toLowerCase();

// Массив для транслитерации
        var transl = {
            'а': 'a', 'б': 'b', 'в': 'v', 'г': 'g', 'д': 'd', 'е': 'e', 'ё': 'e', 'ж': 'zh',
            'з': 'z', 'и': 'i', 'й': 'j', 'к': 'k', 'л': 'l', 'м': 'm', 'н': 'n',
            'о': 'o', 'п': 'p', 'р': 'r','с': 's', 'т': 't', 'у': 'u', 'ф': 'f', 'х': 'h',
            'ц': 'c', 'ч': 'ch', 'ш': 'sh', 'щ': 'sh','ъ': '', 'ы': 'y', 'ь': '\'',
            'э': 'e', 'ю': 'yu', 'я': 'ya', '.': '.', ' ': space
        }

        var result = '';

        for(i=text.length; i >=0; i--) {
            // Если символ найден в массиве то меняем его
            if(transl[text[i]] != undefined) {
                result += transl[text[i]];
            }
            // Если нет, то оставляем так как есть
            else {
                result += '';
            }
        }
        result = TrimStr(result);
// Выводим результат
        $('#al').val(result);
    }

    function TrimStr(s) {
        s = s.replace(/^-/, '');
        return s.replace(/-$/, '');
    }
    // Выполняем транслитерацию при вводе текста в поле
    $(function(){
        $('#name').keyup(function(){
            translit1();
            return false;
        });
    });
</script>

</body>
</html>
