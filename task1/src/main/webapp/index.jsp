<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>

    <title>Index JSP</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form action="controller" method="POST" id="task1">

    <select name="keyword">
        <option>ring</option>
        <option>bell</option>
        <option>light</option>
    </select><br/>
      <input type="submit" value="Submit">

</form>
<div id="result"></div>

<script>
    $(function(){
        $('#task1').submit(function(e){
            e.preventDefault();
            var m_method=$(this).attr('method');
            var m_action=$(this).attr('action');
            var m_data=$(this).serialize();
            $.ajax({
                type: m_method,
                url: m_action,
                data: m_data,
                success: function(result){
                    $('#result').html(result);
                }
            });
        });
    });
</script>
</body>
</html>


