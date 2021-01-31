package jp.dora.sb;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public class TextUtil {
    public static HashMap<Character, int[][]> alphabet = new HashMap<>();

    public static ArrayList<Location> GetTextLocations(String string, Location loc, BlockFace face) {
        if (alphabet.isEmpty()) {
            PopulateAlphabet();
        }
        ArrayList<Location> locs = new ArrayList<>();

        Block block = loc.getBlock();

        int width = 0;
        for (char c : string.toLowerCase().toCharArray()) {
            int[][] letter = alphabet.get(c);

            if (letter != null) {
                width += letter[0].length + 1;
            }
        }

        block = block.getRelative(face, -1 * width / 2 + 1);

        World world = block.getWorld();
        int bX = block.getX();
        int bY = block.getY();
        int bZ = block.getZ();

        for (char c : string.toLowerCase().toCharArray()) {
            int[][] letter = alphabet.get(c);

            if (letter != null) {
                for (int[] ints : letter) {
                    for (int anInt : ints) {
                        if (anInt == 1) {
                            locs.add(new Location(world, bX, bY, bZ));
                        }

                        bX += face.getModX();
                        bY += face.getModY();
                        bZ += face.getModZ();
                    }

                    bX += face.getModX() * -1 * ints.length;
                    bY += face.getModY() * -1 * ints.length;
                    bZ += face.getModZ() * -1 * ints.length;

                    bY--;
                }

                bY += 5;
                bX += face.getModX() * (letter[0].length + 1);
                bY += face.getModY() * (letter[0].length + 1);
                bZ += face.getModZ() * (letter[0].length + 1);
            }
        }
        return locs;
    }

    private static void PopulateAlphabet() {
        alphabet.put('0', new int[][] {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 0, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } });

        alphabet.put('1', new int[][] {
                { 1, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 0 },
                { 1, 1, 1, 0 } });

        alphabet.put('2', new int[][] {
                { 1, 1, 1 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 1 },
                { 1, 1, 1 } });

        alphabet.put('3', new int[][] {
                { 1, 1, 1 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 1 },
                { 1, 1, 1 } });

        alphabet.put('4', new int[][] {
                { 1, 0, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 1 },
                { 0, 0, 1 } });

        alphabet.put('5', new int[][] {
                { 1, 1, 1 },
                { 1 },
                { 1, 1, 1 },
                { 0, 0, 1 },
                { 1, 1, 1 } });

        alphabet.put('6', new int[][] {
                { 1, 1, 1 },
                { 1 },
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } });

        alphabet.put('7', new int[][] {
                { 1, 1, 1 },
                { 0, 0, 1 },
                { 0, 0, 1 },
                { 0, 0, 1 },
                { 0, 0, 1 } });

        alphabet.put('8', new int[][] {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } });

        alphabet.put('9', new int[][] {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 1 },
                { 1, 1, 1 } });

        alphabet.put('.', new int[][] {
                new int[1],
                new int[1],
                new int[1],
                new int[1],
                { 1 } });

        alphabet.put('!', new int[][] {
                { 1 },
                { 1 },
                { 1 },
                new int[1],
                { 1 } });

        alphabet.put(' ', new int[][] {
                new int[2],
                new int[2],
                new int[2],
                new int[2],
                new int[2] });

        alphabet.put('_', new int[][] {
                new int[2],
                new int[2],
                new int[2],
                new int[2],
                new int[2] });

        alphabet.put('a', new int[][] {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 } });

        alphabet.put('b', new int[][] {
                { 1, 1, 1, 0 },
                { 1, 0, 0, 1, 0 },
                { 1, 1, 1, 0 },
                { 1, 0, 0, 1, 0 },
                { 1, 1, 1, 0 } });

        alphabet.put('c', new int[][] {
                { 1, 1, 1, 1 },
                { 1 },
                { 1 },
                { 1 },
                { 1, 1, 1, 1 } });

        alphabet.put('d', new int[][] {
                { 1, 1, 1, 0 },
                { 1, 0, 0, 1, 0 },
                { 1, 0, 0, 1, 0 },
                { 1, 0, 0, 1, 0 },
                { 1, 1, 1, 0 } });

        alphabet.put('e', new int[][] {
                { 1, 1, 1, 1 },
                { 1 },
                { 1, 1, 1 },
                { 1 },
                { 1, 1, 1, 1 } });

        alphabet.put('f', new int[][] {
                { 1, 1, 1, 1 },
                { 1 },
                { 1, 1, 1 },
                { 1 },
                { 1 } });

        alphabet.put('g', new int[][] {
                { 1, 1, 1, 1 },
                { 1 },
                { 1, 0, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 } });

        alphabet.put('h', new int[][] {
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 } });

        alphabet.put('i', new int[][] {
                { 1, 1, 1 },
                { 0, 1 },
                { 0, 1 },
                { 0, 1 },
                { 1, 1, 1 } });

        alphabet.put('j', new int[][] {
                { 1, 1, 1, 1 },
                { 0, 0, 1 },
                { 0, 0, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } });

        alphabet.put('k', new int[][] {
                { 1, 0, 0, 1 },
                { 1, 0, 1 },
                { 1, 1 },
                { 1, 0, 1 },
                { 1, 0, 0, 1 } });

        alphabet.put('l', new int[][] {
                { 1, 0, 0, 0},
                { 1, 0, 0, 0},
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0},
                { 1, 1, 1, 1, 0, 0 } });

        alphabet.put('m', new int[][] {
                { 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 1 } });

        alphabet.put('n', new int[][] {
                { 1, 0, 0, 1 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 } });

        alphabet.put('o', new int[][] {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 } });

        alphabet.put('p', new int[][] {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 },
                { 1 },
                { 1 } });

        alphabet.put('q', new int[][] {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 1 },
                { 1, 1, 0, 1 } });

        alphabet.put('r', new int[][] {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 } });

        alphabet.put('s', new int[][] {
                { 1, 1, 1, 1 },
                { 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 1 },
                { 1, 1, 1, 1 } });

        alphabet.put('t', new int[][] {
                { 1, 1, 1, 1, 1 },
                { 0, 0, 1 },
                { 0, 0, 1 },
                { 0, 0, 1 },
                { 0, 0, 1 } });

        alphabet.put('u', new int[][] {
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 } });

        alphabet.put('v', new int[][] {
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 0, 1, 1 } });

        alphabet.put('w', new int[][] {
                { 1, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1 } });

        alphabet.put('x', new int[][] {
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 0, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 } });

        alphabet.put('y', new int[][] {
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 1 },
                { 1, 1, 1, 1 } });

        alphabet.put('z', new int[][] {
                { 1, 1, 1, 1 },
                { 0, 0, 0, 1 },
                { 0, 0, 1 },
                { 0, 1 },
                { 1, 1, 1, 1 } });
    }


    @SuppressWarnings("deprecation")
    public static void MakeText(Player player, String string, Location loc, BlockFace face, Material id, byte data) {
        for(Location l : TextUtil.GetTextLocations(string, loc, face)){
            player.sendBlockChange(l, id, data);
        }

    }
}
