module Main where

import Lib

main :: IO ()
main = do
  let result = countPairs input 10
  putStrLn $ "Pair count which sums to 10: " ++ show result

input :: Tree
input =
  Node
    5
    (Node 3 (Node 2 Empty Empty) (Node 4 Empty Empty))
    (Node 7 (Node 6 Empty Empty) (Node 8 Empty Empty))
