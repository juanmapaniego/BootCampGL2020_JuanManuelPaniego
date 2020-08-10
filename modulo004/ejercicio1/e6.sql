SELECT * 
FROM ANIMALS a
WHERE a.weight <= 100
ORDER BY a.id ASC, a.species;
#
SELECT a.species, COUNT(*) as cant
FROM ANIMALS a
WHERE a.weight <= 100
GROUP BY a.species
ORDER BY COUNT(*);