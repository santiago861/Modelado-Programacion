(deffacts estado-inicial
	(estado levantandose)
	(pantalon puesto)
	(pie derecho desnudo)
	(pie izquierdo desnudo)
	(calcetin derecho)
	(calcetin izquierdo)
	(zapato derecho)
	(zapato izquierdo)
)

;************************************************
; REGLAS Zapatos
;************************************************
; Regla inicial
(defrule inicio
	(estado levantandose)
	(pantalon puesto)
	(pie ?pie desnudo)
	=>
	(assert (colocar zapato ?pie))
)


; Coloca el calcetin
(defrule colocar-calcetin
	(colocar zapato ?pie)
	?f1 <- (pie ?pie desnudo)
	?f2 <- (calcetin ?pie)
	=>
	(retract ?f1 ?f2)
	; Directiva PONER
	(assert (PONER calcetin ?pie))
)

; Coloca el zapato
(defrule colocar-zapato
	?f1 <- (colocar zapato ?pie)
	(not (pie ?pie desnudo))
	?f2 <- (zapato ?pie)
	=>
	(retract ?f1 ?f2)
	; Directiva PONER
	(assert (PONER zapato ?pie))
)


