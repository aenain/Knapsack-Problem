Dobra, naklepa�em co� co (chyba) dzia�a...
Dok�adniej:
- jak stosuj� funkcj� kary to zasadniczo si� pierdoli (przekracza wag� - w sumie to 
  nic dziwnego, w�tpie czy co� si� da z tym zrobi�)
- jak stosuj� funkcj� naprawy to z moich obserwacji wynika, �e dzia�a jak trzeba
  (nie przekracza wagi)... wzgl�dem dok�adnego algorytmu (dynamicznego) wychodzi, 
  �e ten genetyczny jest �rednio 2x gorszy (i przy okazji wolniejszy dla moich przypadk�w :P)

Co zosta�o zrobione:
- silnik - no jak m�wi�em niby to dzia�a :P
- niekt�re operatory genetyczne, takie jak: liniowa funkcja kary, troche-losowa funkcja naprawy,
  krzy�owanie jednopunktowe, selekcja ruletkowa, mutacje
- interfejsy u�atwiaj�ce rozbud� o nowe operatory genetyczne
- algorytm obliczaj�cy dok�adny wynik - programowanie dynamiczne

Co by wypada�o zrobi�:
- inne operatory genetyczne
- dok�adniej to przetestowa�
- ewentualne dopieszczenia i poprawki kodu
- GUI
- integracja wszystkiego w jedn� ca�o��

Co do kodu, to my�l�, �e go w miar� czytelnie napisa�em i z komentarzami, wi�c nie powinni�cie
mie� wi�kszych problem�w z rozkminieniem o co chodzi, dla u�atwienia kr�tki opis co i jak:
1. Klasy/interfejsy i za co odpowiadaj�:
  a) Genome - reprezentacja pojedynczego osobnika, zawiera jego materia� genetyczny oraz podstawowe
  warto�ci go opisuj�ce - sum� wag przedmiot�w, przystosowanie, etc. i troch� metod s�u��cych do operowania nimi
  b) Population - opisuje ca�� populacj�, czyli zawiera chromosomy wszystkich osobnik�w, indeksy i warto�ci
  najlepszych/najgorszych osobnik�w, umo�liwia generowanie losowych osobnik�w oraz obliczanie ich warto�ci i wag ich przedmiot�w
  c) Evolution - kontroluje ca�� ewolucje, tworzy kolejne populacje, ocenia je, itp.
  d) Subject - opisuje pojedynczy przedmiot, czyli jego wag� i warto��
  e) PunishFitness - interfejs umo�liwiaj�cy tworzenie r�nych funkcji kary
  f) LinearPunishFitness - przyk�adowa implementacja powy�szego interfejsu, liniowa funkcja kary
  g) CompareGenome - por�wnywaczka genom�w wzgl�dem ich warto�ci, itp - potrzebne do sortowania
  h) SelectionMethod - interfejs do tworzenia funkcji wybieraj�cych osobnik�w z populacji
  i) RouletteSelection - implementacja powy�szego interfejsu, ruletkowy wyb�r osobnik�w
  j) CrossoverMethod - interfejs do funkcji krzy�uj�cych
  k) SinglePointCrossover - krzy�owanie jednopunktowe korzystaj�ce z powy�szego interf.
  l) RepairFitness - interfejs do tworzenia funkcji naprawy
  m) RandModuloRepairFitness - przyk�adowa funkcja naprawy
  n) DynamicsKnapsackProblem - tworzona na szybkiego klasa rozwi�zuj�ca problem programowaniem dynamicznym
  o) KnapsackProblem - "main" wraz z przyk�adowym odpaleniem algo genetycznego i dynamicznego oraz ich por�wnaniem
2. Operatory genetyczne, zgodne z pomys�em Hebdy, opieraj� si� na interfejsach przez co mo�na �atwo dobudowa� nowe funkcje
  a potem je przekazac do algorytmu. Mo�liwe, �e troche za du�o tych interfejs�w, ale przynajmniej wygl�daj� na dzia�aj�ce :P

Zasadniczo jak uwa�acie, �e co� mo�na lepiej zrobi�, poprawi� czy co�, to �mia�o mo�ecie tam zmienia� co chcecie, byleby by
to p�niej chocia� udawa�o, �e dzia�a.

W razie pyta� i innych wa�nych spraw, to mo�na mnie jeszcze dzi� (12.04) dorwa� na gg (mog� by� niewidoczny), 
ewentualnie jutro na uczelni.
W skrajnych przypadkach mo�na pr�bowa� dzwoni� do mnie w weekend ale zasadniczo to jest spos�b do�� niepewny :P

No to chyba tyle :)
Pozdrawiam.


