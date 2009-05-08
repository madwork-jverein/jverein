<? include ("frame.inc"); ?>
    <h1>Mitglied</h1>
    <p>
    <a name="Suche"></a>
    <h2>Suche</h2>
    <img src='images/Mitgliedsuche.jpg' class='screenshot'>
    <p>Die Mitglieder sind nach dem Anfangsbuchstaben des Namens in die einzelnen Karteireiter einsortiert. 
    	In dem Karteireiter mit dem Stern sind alle Mitglieder eingetragen. Das System stellt immer den 
    	zuletzt benutzten Karteireiter wieder her. Nach einem Doppelklick auf das Mitglied werden die 
    	kompletten Daten angezeigt. Mit einem Rechtsklick auf ein Mitglied �ffnet sich ein Kontextmen�. 
    	Damit kann das Mitglied bearbeitet oder gel�scht werden. Au�erdem ist die Ausstellung 
    	einer <a href="spendenbescheinigung.php">Spendenbescheinigung</a> m�glich.</p>
    <p>Die Selektion nach den Mitgliedschafts-Stati "Angemeldet", "Abgemeldet" und "Beide" ist m�glich. 
    	Weiterhin kann nach den Eigenschaften, einem Geburtszeitraum und nach Beitragsgruppen selektiert 
    	werden.</p>
    	
    <img src='images/Mitgliedsucheeigenschaften.jpg' class='screenshot'>
    <p>Es k�nnen eine oder mehrere Eigenschaften ausgew�hlt werden (STRG-Taste beim Mausklick gedr�ckt 
    	halten). Die Eigenschaften sind "und-verkn�pft". D. h. es werden die Mitglied angezeigt, die 
    	alle Eigenschaften haben.</p>
    
    <a name="Grunddaten_des_Mitgliedes"></a>
    <h2>Grunddaten des Mitgliedes</h2>
    <img src='images/Mitgliedgrunddaten.jpg' class='screenshot'>
    <p>Im oberen Teil sind die allgemeinen Daten des Mitgliedes zu finden. Wird eine Postleitzahl
		eingegeben, f�r die bereits ein Mitglied gespeichert ist, wird der entsprechende Ort
		�bernommen.</p>
	<p>Als Zahlungswege stehen</p>
	<ul>
		<li>Abbuchung</li>
		<li>Barzahlung</li>
		<li>�berweisung</li>
	</ul>
	<p>zur Verf�gung.</p>
	<p>Beim Zahlungsweg Abbuchung werden Bankleitzahl und die Kontonummer auf Plausibilit�t
		�berpr�ft. Zus�tzlich kann ein abweichender Kontoinhaber eingegeben werden.</p>
		
	<p>Sofern in den <a href="administration_einstellungen.php">Einstellungen</a> der Parameter
		"Juristische Personen erlaubt" gesetzt ist, wird bei der Neuaufnahme von Mitgliedern folgender
		Dialog eingeblendet:</p>
	<img src='images/MitgliedPersonenart.png' class='screenshot'>
	<p>Hier kann ausgew�hlt werden ob es sich um eine </p>
	<ul>
		<li>nat�rliche Person</li>
		<li>juristische Person</li>
	</ul>
	<p>handelt. Sofern "juristische Person" ausgew�hlt wird, sieht der Bildschirm so aus:</p>
	<img src='images/MitgliedJuristischePerson.png' class='screenshot'>
		
		
	<a name="Mitgliedschaft"></a>
	<h2>Mitgliedschaft</h2>
	<p>Eintrittsdatum und Beitragsgruppe sind Pflichtfelder. Die Beitragsgruppen k�nnen unter 
		<a href="administration_beitragsgruppen.php">Beitragsgruppen</a> f�r jeden Verein individuell 
		konfiguriert werden. Beim Austrittsdatum wird das Datum des satzungsgem��en Austritts 
		(z. B. der 31.12. des jeweiligen Jahres) eingetragen. Unter K�ndigung wird das Datum des 
		Eingangs der K�ndigung vermerkt.</p>
	<p>Sofern eine Beitragsgruppe ausgew�hlt wurde, die mit "Familie: Zahler" gekennzeichnet ist, 
		ver�ndert sich das Formular wie folgt:</p>
	<img src='images/Mitgliedmitgliedschaftfamiliezahler.jpg' class='screenshot'>
	<p>Die Person (selber Mitglied), die f�r das Mitglied zahlt, kann aus einer Liste ausgew�hlt werden.</p>
	<p>Bei einer Beitragsgruppe, die mit "Familie: Angeh�riger" gekennzeichnet ist, sieht das Formular so 
		aus:</p>
	<img src='images/Mitgliedmitgliedschaftfamiliemitglied.jpg' class='screenshot'>
	<p>Hier werden die Personen angezeigt, f�r die das Mitglied die Beitr�ge zahlt.</p>
	<p>Sinn und Zweck dieser Familienverkn�pfung ist es, die Voraussetzungen f�r die Familienmitgliedschaft 
		pr�fen zu k�nnen. Tritt ein Mitglied, dass f�r andere Mitglieder als Zahler eingetrgen ist, aus, 
		kommt eine entsprechende Fehlermeldung. Dann sind die Beitragsgruppen der beitragsfreien Mitglieder 
		zu ver�ndern oder es ist ein anderer Zahler einzutragen.</p>
	<a name="Zusatzbetraege"></a>
	<h2>Zusatzbetr�ge</h2>
	<p>Zus�tzliche Zahlungen (z. B. Eigenanteile f�r Fahrten, Strafgelder ...) k�nnen �ber Zusatzbetr�ge 
		verarbeitet werden.</p>
	<img src='images/Mitgliedzusatzabbuchung.jpg' class='screenshot'>
	<p>Ein Klick auf Neu �ffnet folgendes Fenster.</p>
	<img src='images/Mitgliedzusatzabbuchungneu.jpg' class='screenshot'>
	
	<a name="Vermerke"></a>
	<h2>Vermerke</h2>
	<p>Vermerke �ber das Mitglied (z. B. Funktionen ...) k�nnen in zwei Datenfeldern hinterlegt werden.</p>
	<img src='images/Mitgliedvermerke.jpg' class='screenshot'>
	
	<a name="Wiedervorlage"></a>
	<h3>Wiedervorlage</h3>
	<img src='images/Mitgliedwiedervorlage.jpg' class='screenshot'>
	<p>Mit einem Rechtsklick auf einen Wiedervorlagetermin kann entweder ein Erledigungsdatum gesetzt oder 
		zur�ckgesetzt werden. Mit einem Klick  auf Neu �ffnet sich folgendes Fenster:</p>
	<img src='images/Mitgliedwiedervorlageneu.jpg' class='screenshot'>
	
	<a name="Eigenschaften"></a>
	<h2>Eigenschaften</h2>
	<img src='images/Mitgliedeigenschaften.jpg' class='screenshot'>
	<p>Die bereits gespeicherten Eigenschaften werden angezeigt. Durch einen rechten Mausklick �ffnet sich 
		ein Kontextmen�. Damit k�nnen existierende Eigenschaften entfernt oder neue Eigenschaften aufgenommen 
		werden.</p>
	<img src='images/Mitgliedeigenschaftenneu.jpg' class='screenshot'>
	<p>In der Tabelle werden die Eigenschaften angezeigt, die dem Mitglied bislang noch nicht zugeordnet 
		wurden. Durch einen Doppelklick wird eine existierende Eigenschaft eingetragen. Alternativ kann 
		der Text auch �ber die Tastatur eingegeben werden. Neu hinzugef�gte Eigenschaften stehen anschlie�end 
		f�r alle anderen Mitglieder zur Auswahl zur Verf�gung.</p>

	<a name="Zusatzfelder"></a>
	<h2>Zusatzfelder</h2>
	<p>Ab Version 1.1</p>
	<img src='images/MitgliedZusatzfelder.jpg' class='screenshot'>
	<p>Durch <a href="administration_felddefinitionen.php">Definition von Zusatzfeldern</a> die k�nnen 
		zus�tzliche Datenfelder erfasst werden.</p>

    <!-- 
    $Log$
    Revision 1.3  2009/05/05 17:28:50  jost
    Neu: Juristische Personen als Mitglieder

    Revision 1.2  2009/05/03 15:33:30  jost
    Neue Homepage

    -->
    
<? include ("footer.inc"); ?>
