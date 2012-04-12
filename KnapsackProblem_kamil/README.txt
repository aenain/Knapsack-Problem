Dobra, naklepa³em coœ co (chyba) dzia³a...
Dok³adniej:
- jak stosujê funkcjê kary to zasadniczo siê pierdoli (przekracza wagê - w sumie to 
  nic dziwnego, w¹tpie czy coœ siê da z tym zrobiæ)
- jak stosujê funkcjê naprawy to z moich obserwacji wynika, ¿e dzia³a jak trzeba
  (nie przekracza wagi)... wzglêdem dok³adnego algorytmu (dynamicznego) wychodzi, 
  ¿e ten genetyczny jest œrednio 2x gorszy (i przy okazji wolniejszy dla moich przypadków :P)

Co zosta³o zrobione:
- silnik - no jak mówi³em niby to dzia³a :P
- niektóre operatory genetyczne, takie jak: liniowa funkcja kary, troche-losowa funkcja naprawy,
  krzy¿owanie jednopunktowe, selekcja ruletkowa, mutacje
- interfejsy u³atwiaj¹ce rozbudê o nowe operatory genetyczne
- algorytm obliczaj¹cy dok³adny wynik - programowanie dynamiczne

Co by wypada³o zrobiæ:
- inne operatory genetyczne
- dok³adniej to przetestowaæ
- ewentualne dopieszczenia i poprawki kodu
- GUI
- integracja wszystkiego w jedn¹ ca³oœæ

Co do kodu, to myœlê, ¿e go w miarê czytelnie napisa³em i z komentarzami, wiêc nie powinniœcie
mieæ wiêkszych problemów z rozkminieniem o co chodzi, dla u³atwienia krótki opis co i jak:
1. Klasy/interfejsy i za co odpowiadaj¹:
  a) Genome - reprezentacja pojedynczego osobnika, zawiera jego materia³ genetyczny oraz podstawowe
  wartoœci go opisuj¹ce - sumê wag przedmiotów, przystosowanie, etc. i trochê metod s³u¿¹cych do operowania nimi
  b) Population - opisuje ca³¹ populacjê, czyli zawiera chromosomy wszystkich osobników, indeksy i wartoœci
  najlepszych/najgorszych osobników, umo¿liwia generowanie losowych osobników oraz obliczanie ich wartoœci i wag ich przedmiotów
  c) Evolution - kontroluje ca³¹ ewolucje, tworzy kolejne populacje, ocenia je, itp.
  d) Subject - opisuje pojedynczy przedmiot, czyli jego wagê i wartoœæ
  e) PunishFitness - interfejs umo¿liwiaj¹cy tworzenie ró¿nych funkcji kary
  f) LinearPunishFitness - przyk³adowa implementacja powy¿szego interfejsu, liniowa funkcja kary
  g) CompareGenome - porównywaczka genomów wzglêdem ich wartoœci, itp - potrzebne do sortowania
  h) SelectionMethod - interfejs do tworzenia funkcji wybieraj¹cych osobników z populacji
  i) RouletteSelection - implementacja powy¿szego interfejsu, ruletkowy wybór osobników
  j) CrossoverMethod - interfejs do funkcji krzy¿uj¹cych
  k) SinglePointCrossover - krzy¿owanie jednopunktowe korzystaj¹ce z powy¿szego interf.
  l) RepairFitness - interfejs do tworzenia funkcji naprawy
  m) RandModuloRepairFitness - przyk³adowa funkcja naprawy
  n) DynamicsKnapsackProblem - tworzona na szybkiego klasa rozwi¹zuj¹ca problem programowaniem dynamicznym
  o) KnapsackProblem - "main" wraz z przyk³adowym odpaleniem algo genetycznego i dynamicznego oraz ich porównaniem
2. Operatory genetyczne, zgodne z pomys³em Hebdy, opieraj¹ siê na interfejsach przez co mo¿na ³atwo dobudowaæ nowe funkcje
  a potem je przekazac do algorytmu. Mo¿liwe, ¿e troche za du¿o tych interfejsów, ale przynajmniej wygl¹daj¹ na dzia³aj¹ce :P

Zasadniczo jak uwa¿acie, ¿e coœ mo¿na lepiej zrobiæ, poprawiæ czy coœ, to œmia³o mo¿ecie tam zmieniaæ co chcecie, byleby by
to póŸniej chocia¿ udawa³o, ¿e dzia³a.

W razie pytañ i innych wa¿nych spraw, to mo¿na mnie jeszcze dziœ (12.04) dorwaæ na gg (mogê byæ niewidoczny), 
ewentualnie jutro na uczelni.
W skrajnych przypadkach mo¿na próbowaæ dzwoniæ do mnie w weekend ale zasadniczo to jest sposób doœæ niepewny :P

No to chyba tyle :)
Pozdrawiam.


