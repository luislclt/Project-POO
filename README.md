# Project-POO
Trabalho Prático de Programação Orientada a Objetos

Objetivos
Com a realização do trabalho prático, pretende-se que os alunos ponham em prática todos
os conhecimentos adquiridos na utilização do paradigma de programação orientado a
objetos e a sua implementação na linguagem de programação Java, demonstrando as suas
apetências em:
● Conhecer e compreender os conceitos fundamentais associados ao paradigma da
programação orientada a objetos;
● Conceber e implementar, para problemas concretos, soluções que tenham por base
o paradigma da programação orientada a objetos;
● Reconhecer e compreender a semântica e a sintaxe da linguagem Java;
● Reutilizar, alterar e desenvolver código recorrendo à linguagem Java tendo em vista
um determinado problema com regras semânticas específicas;
● Não é permitida a utilização de API’s/conceitos Java que não tenham sido alvo de
lecionação - ano letivo 2016-2017 - da unidade curricular Programação Orientada a
Objetos. Os alunos que pretendam utilizar API’s adicionais devem atempadamente
pedir autorização a um dos docentes da unidade curricular;
● Não é permitida a utilização de coleções Java predefinidas (Java Collections
Framework).
O portal football-data.org ​é um portal web que se dedica à disponibilização da
dados de futebol de todas as principais ligas europeias de uma forma legível e fidedigna.
Estes dados incluem equipas, jogadores, resultados e outros dados estatísticos acerca
deste desporto mundialmente conhecido. Este portal disponibiliza ainda uma API para o
1
desenvolvimento de aplicações sendo a disponibilização dos dados estatísticos feita em
formato JSON (JavaScript Object Notation) . Na figura que se segue pode ver-se o
2
resultado de um pedido (http://api.football-data.org/v1/competitions/439) através da API do
3
portal football-data.org, que retorna informação acerca da 1ª liga do compeonato português
de futebol (este campeonato tem o id=439):

Associado a um campeonato específico, a API disponibiliza os links para aceder a
informação complementar, nomeadamente as equipas (.*/teams), os jogos (.*/fixtures) e a
classificação (.*/leagueTable) que cada campeonato tem numa determinada época (a época
ficará associado a um determinado ano: por exemplo, na Figura 1, a época é 2016/2017,
pois o campo “year” é 2016). Para aceder aos jogadores de determinada equipa, é
necessário enviar um pedido através da API para consulta de uma equipa
(http://api.football-data.org/v1/teams/<<id da equipa>>) e só depois consultar os jogadores
dessa equipa (http://api.football-data.org/v1/teams/<<id da equipa>>/players) .
4
Atualmente este portal não permite o armazenamento de dados de forma persistente
sendo que, numa determinada época, os dados da época anterior são descartados. Assim,
pretende-se desenvolver em linguagem Java, uma aplicação para suportar um conjunto de
requisitos específicos tendo por base os dados disponibilizados pela API do portal
football-data.org. Deste modo, é necessária a criação de uma API que permita expor as
funcionalidades inerentes à recolha, tratamento e análise de dados tendo por base alguns
conteúdos disponibilizados pela API deste portal sendo que, nesta primeira fase , apenas se
pretenda obter informação acerca do campeonato ibérico, isto é, do campeonato Português
(id = 439) e Espanhol (id = 436). Assim, deverá incluir pelo menos as seguintes (outras
poderão existir) funcionalidades:
● Obter uma listagem de todos os jogadores de uma determinada equipa numa
determinada época;

Visualizar os jogos agendados/terminados para um determinado intervalo de datas
numa determinada época e num determinado campeonato. No caso de jogos
terminados pretende-se saber o resultado final desses jogos;
● Obter uma listagem dos jogadores mais valiosos de um determinado campeonato,
ordenada por ordem decrescente do seu valor de mercado;
● A API deverá ser construída para que a adição de novos conteúdos (por exemplo,
novos campeonatos) não implique a alteração do código implementado para as
funcionalidades especificadas nos pontos anteriores.
É ainda disponibilizada uma API (ResourcesAPI ) que contém os contratos que devem (no
mínimo) ser implementados para a realização do trabalho. A não utilização da API
ResourcesAPI ​invalida todo o trabalho! ​Os recursos disponibilizados já possuem todos
os mecanismos de acesso à API do portal de futebol. As instruções para a utilização da
API do portal de futebol encontram-se disponibilizados nos recursos de suporte ao
trabalho. ​Os pedidos efetuados através da API encontram-se em formato JSON , devendo
5
ser realizada a interpretação dos dados utilizando uma API JSON à sua escolha.
