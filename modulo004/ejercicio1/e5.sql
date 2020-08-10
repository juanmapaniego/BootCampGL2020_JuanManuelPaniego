SELECT * 
FROM ANIMALS a
ORDER BY a.id ASC, a.species;
#
SELECT a.species, COUNT(*) as cant
FROM ANIMALS a
GROUP BY a.species
ORDER BY COUNT(*);