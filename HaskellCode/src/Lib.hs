module Lib
  ( Tree(..)
  , countPairs
  ) where

import Data.List (delete, elem)
import Debug.Trace (trace)

data Tree
  = Empty
  | Node Int
         Tree
         Tree
  deriving (Show)

countPairs :: Tree -> Int -> Int
countPairs tree sum = fst $ helper tree []
  where
    helper :: Tree -> [Int] -> (Int, [Int])
    helper Empty values = (0, values)
    helper (Node value left right) pairs
      | elem value pairs =
        trace ("(" ++ show value ++ ", " ++ show (sum - value) ++ ")") $ eval 1
      | otherwise = eval 0
      where
        newValues old = (sum - value) : (delete value old)
        eval init =
          let (leftValue, leftPairs) = helper left (newValues pairs)
              (rightValue, rightPairs) = helper right (newValues leftPairs)
           in (init + leftValue + rightValue, rightPairs)
