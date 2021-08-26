# sazbyDPH
První projekt — Sazby DPH
Na prvním projektu byste si měli ověřit, že jste zvládli témata prvních šesti lekcí.
K projektu nebudete mít vzorové řešení.
Vaše řešení byste měli odevzdat v repozitáři, který si pro tento účel vytvoříte.
Zadání
Naprogramuj aplikaci v Javě, která vypíše všechny státy Evropské unie, které mají sazbu daně z přidané hodnoty (DPH, VAT) vyšší, než 20 % a nepoužívají speciální sazbu DPH/VAT.
Aktuální data o jednotlivých státech a jejich daních dostaneš v souboru — vzorový soubor je ke stažení zde: vat-eu.csv.
Vstupní soubor bude ve stejné složce, jako projekt aplikace.
Formát vstupního souboru
Na každém řádku vstupního souboru jsou informace o jednom státu v následujícím formátu:
•	zkratka státu (například AT)
•	název státu (Austria)
•	plná sazba daně z přidané hodnoty v procentech (20)
•	snížená sazba daně z přidané hodnoty v procentech (10)
•	informace o tom, jestli země používá speciální sazbu DPH pro některé produkty (true/false)
Jednotlivé hodnoty jsou odděleny vždy tabulátorem.
Příklad několika řádků souboru:
AT	Austria	20	10	true
BE	Belgium	21	12	true
BG	Bulgaria	20	9	false
CY	Cyprus	19	9	false
CZ	Czech Republic	21	15	false
Výstup aplikace
Postupně zpracuj tyto kroky:
1.	Vypiš seznam všech států a u každého uveď základní sazbu daně z přidané hodnoty ve formátu:
2.	Název země (zkratka): základní sazba %
Například:
Austria (AT): 20 %
Belgium (BE): 21 %
...
3.	Vypište ve stejném formátu pouze státy, které mají základní sazbu daně z přidané hodnoty vyšší než 20 % a přitom nepoužívají speciální sazbu daně.
4.	Výpis seřaď podle výše základní sazby DPH/VAT sestupně (nejprve státy s nejvyšší sazbou).
5.	Pod výpis doplň řádek s rovnítky pro oddělení a poté seznam zkratek států, které ve výpisu nefigurují.
Například:
Sweden (SE):    25 %
Croatia (HR):   25 %
...
Finland (FI):   24 %
...
====================
Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: AT, CY, CZ,... 
6.	Výsledný výpis zapiš také do souboru s názvem vat-over-20.txt. Výstupní soubor ulož do stejné složky, ve které byl vstupní soubor. (Výpis na obrazovku zůstává.)
7.	Doplň možnost, aby uživatel z klávesnice zadal výši sazby DPH/VAT, podle které se má filtrovat. Vypíší se tedy státy se základní sazbou vyšší než ta, kterou uživatel zadal.
o	Pokud uživatel zmáčkne pouze Enter, jako výchozí hodnota se použij jako výchozí sazbu 20 %.
o	Uprav název výstupního souboru tak, aby reflektoval zadanou sazbu daně.


