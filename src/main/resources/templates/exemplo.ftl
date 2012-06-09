<html>
<head>
  <title>Seja bem-vindo!</title>
</head>
<body>
  <h1>Bem-vindo ${usuario}!</h1>
  <p>We have these animals:
  <ul>
  <#list animais as animal>
    <li>${animal.nome} por ${animal.preco} reais
  </#list>
  </ul>
</body>
</html>  