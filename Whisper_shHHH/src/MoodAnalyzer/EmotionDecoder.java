package MoodAnalyzer;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class EmotionDecoder {
    // Color codes for terminal output
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";



    public static void analyzeEmotion(String text) {
        // Initialize emotion scores using HashMap for better management
        Map<String, Integer> emotions = new HashMap<>();
        emotions.put("HAPPY", 0);
        emotions.put("SAD", 0);
        emotions.put("ANGRY", 0);
        emotions.put("FEAR", 0);
        emotions.put("LOVE", 0);
        emotions.put("HATE", 0);

        // Comprehensive emotion word banks
        String[] happyWords = {
                "happy", "glad", "joyful", "cheerful", "content", "delighted", "ecstatic",
                "elated", "jubilant", "merry", "thrilled", "upbeat", "chipper", "playful",
                "lighthearted", "radiant", "glowing", "wonderful", "fantastic", "marvelous",
                "blessed", "peaceful", "calm", "serene", "optimistic", "positive", "amused",
                "jovial", "mirthful", "gratified", "proud", "triumphant", "over the moon",
                "on cloud nine", "walking on air", "exuberant", "bouncy", "peppy", "peachy",
                "sunny", "blissful", "rapturous", "euphoric", "inspired", "good", "great",
                "awesome", "excited", "amazing", "brilliant", "fun", "smile", "smiling",
                "laugh", "laughing", "joy", "celebration", "celebrate", "pleased", "satisfied"
        };

        String[] sadWords = {
                "sad", "unhappy", "sorrowful", "dejected", "regretful", "depressed",
                "downcast", "miserable", "blue", "gloomy", "low", "somber", "dismal",
                "melancholy", "heavyhearted", "woeful", "forlorn", "wretched", "hopeless",
                "unfortunate", "pitiful", "mournful", "disheartened", "disconsolate",
                "heartbroken", "crushed", "devastated", "shattered", "despairing",
                "agonized", "tortured", "inconsolable", "desolate", "grief", "anguish",
                "torn up", "destroyed", "gutted", "bummed", "down", "sulky", "glum",
                "mopey", "pensive", "disappointed", "let down", "discouraged", "feeling down",
                "in the dumps", "heavy heart", "fallen apart", "feeling blue", "under the weather",
                "not okay", "hurt", "aching", "lonely", "isolated", "empty", "worthless",
                "crying", "tears", "weeping", "sobbing"
        };

        String[] angryWords = {
                "angry", "mad", "upset", "irritated", "cross", "resentful", "indignant",
                "bitter", "heated", "surly", "offended", "vexed", "piqued", "displeased",
                "furious", "outraged", "livid", "fuming", "wrathful", "seething",
                "incandescent", "enraged", "ballistic", "explosive", "ferocious",
                "fierce", "infuriated", "irate", "violent", "frenzied", "annoyed",
                "peeved", "bugged", "bothered", "cranky", "miffed", "irked", "impatient",
                "frustrated", "disgruntled", "grumpy", "testy", "fed up", "done with",
                "pissed off", "seeing red", "at my wit's end", "boiling point",
                "fit to be tied", "lose my cool", "blow a fuse", "hitting the roof",
                "up in arms", "had it", "sick of", "rage", "aggressive", "hostile"
        };

        String[] fearWords = {
                "scared", "afraid", "fearful", "frightened", "alarmed", "spooked",
                "intimidated", "shaken", "trembling", "startled", "aghast", "unnerved",
                "terrified", "panicked", "horrified", "petrified", "paralyzed",
                "frantic", "hysterical", "dread", "terror", "angst", "nightmare",
                "blood-curdling", "scared to death", "frozen", "anxious", "nervous",
                "uneasy", "apprehensive", "worried", "jumpy", "jittery", "tense",
                "restless", "fidgety", "hesitant", "cautious", "on edge", "freaked out",
                "butterflies", "cold feet", "shaking", "sweating", "paranoid",
                "heart racing", "scared stiff", "chills", "creeps", "spine-chilling",
                "can't breathe", "panic", "stress", "stressed", "overwhelmed", "insecure"
        };

        String[] hateWords = {
                "hate", "loathe", "despise", "detest", "abhor", "resent", "dislike",
                "aversion", "disdain", "scorn", "animosity", "antipathy", "execrate",
                "malicious", "venomous", "spiteful", "abominable", "vile", "revolting",
                "disgusting", "loathsome", "nauseating", "repulsive", "odious",
                "pure evil", "malignant", "hostile", "bitter", "rancorous",
                "grossed out", "repelled", "sickened", "offended", "revolted",
                "unbearable", "obnoxious", "insufferable", "detestable", "grudge",
                "can't stand", "wish you were gone", "hate your guts", "makes my skin crawl",
                "poisonous", "toxic", "disgusts me", "garbage", "awful",
                "horrible", "terrible", "worst", "enemy"
        };

        String[] loveWords = {
                "love", "adore", "cherish", "fond", "admire", "affection", "devotion",
                "attachment", "warmth", "tender", "kind", "caring", "gentle", "sweet",
                "passionate", "infatuated", "enamored", "worship", "idolize", "eternal",
                "unconditional", "burning", "obsessed", "soulmate", "captivated",
                "rapturous", "irresistible", "breathless", "like", "crush", "friendly",
                "attached", "amorous", "soft", "pleasant", "charming", "lovely", "dear",
                "darling", "precious", "head over heels", "crazy about", "fallen for",
                "heart eyes", "sweet on", "meant to be", "my everything", "belong together",
                "can't live without", "smitten", "struck by cupid", "wild about", "into you",
                "romance", "romantic", "kiss", "hug", "embrace", "sweetheart", "beloved"
        };

        // Intensity multipliers for extreme words
        String[] extremeIntensifiers = {
                "very", "extremely", "incredibly", "absolutely", "totally", "completely",
                "utterly", "really", "so", "super", "mega", "ultra", "intensely",
                "deeply", "profoundly", "overwhelmingly", "exceedingly", "exceptionally"
        };

        String[] strongIntensifiers = {
                "quite", "pretty", "rather", "fairly", "somewhat", "kind of", "sort of"
        };

        // Check for intensity modifiers
        int intensityBonus = 0;
        for (String intensifier : extremeIntensifiers) {
            if (text.contains(intensifier)) {
                intensityBonus += 30; // Strong boost for extreme words
            }
        }
        for (String intensifier : strongIntensifiers) {
            if (text.contains(intensifier)) {
                intensityBonus += 15; // Moderate boost
            }
        }

        // Count emotion matches with weighted scoring based on word intensity
        for (String word : happyWords) {
            if (text.contains(word)) {
                int baseScore = getWordIntensity(word);
                emotions.put("HAPPY", emotions.get("HAPPY") + baseScore);
            }
        }
        for (String word : sadWords) {
            if (text.contains(word)) {
                int baseScore = getWordIntensity(word);
                emotions.put("SAD", emotions.get("SAD") + baseScore);
            }
        }
        for (String word : angryWords) {
            if (text.contains(word)) {
                int baseScore = getWordIntensity(word);
                emotions.put("ANGRY", emotions.get("ANGRY") + baseScore);
            }
        }
        for (String word : fearWords) {
            if (text.contains(word)) {
                int baseScore = getWordIntensity(word);
                emotions.put("FEAR", emotions.get("FEAR") + baseScore);
            }
        }
        for (String word : hateWords) {
            if (text.contains(word)) {
                int baseScore = getWordIntensity(word);
                emotions.put("HATE", emotions.get("HATE") + baseScore);
            }
        }
        for (String word : loveWords) {
            if (text.contains(word)) {
                int baseScore = getWordIntensity(word);
                emotions.put("LOVE", emotions.get("LOVE") + baseScore);
            }
        }

        // Apply intensity bonus to all detected emotions
        if (intensityBonus > 0) {
            for (String emotion : emotions.keySet()) {
                if (emotions.get(emotion) > 0) {
                    emotions.put(emotion, emotions.get(emotion) + intensityBonus);
                }
            }
        }

        // Check for negation words that might flip emotions
        boolean hasNegation = text.contains("not ") || text.contains("no ") ||
                text.contains("never ") || text.contains("isn't") ||
                text.contains("don't") || text.contains("doesn't") ||
                text.contains("can't") || text.contains("won't");

        if (hasNegation) {
            if (text.contains("not happy") || text.contains("not good")) {
                emotions.put("HAPPY", Math.max(0, emotions.get("HAPPY") - 40));
                emotions.put("SAD", emotions.get("SAD") + 20);
            }
            if (text.contains("not sad")) {
                emotions.put("SAD", Math.max(0, emotions.get("SAD") - 40));
            }
            if (text.contains("not afraid") || text.contains("not scared")) {
                emotions.put("FEAR", Math.max(0, emotions.get("FEAR") - 40));
            }
        }

        // Find the HIGHEST emotion(s)
        int maxScore = Math.max(
                Math.max(Math.max(emotions.get("HAPPY"), emotions.get("SAD")),
                        Math.max(emotions.get("ANGRY"), emotions.get("FEAR"))),
                Math.max(emotions.get("LOVE"), emotions.get("HATE"))
        );

        // Collect all emotions with the highest score (handles ties)
        String dominantEmotion = "";
        int tieCount = 0;

        for (Map.Entry<String, Integer> entry : emotions.entrySet()) {
            if (entry.getValue() == maxScore && maxScore > 0) {
                if (tieCount > 0) {
                    dominantEmotion += " & ";
                }
                dominantEmotion += entry.getKey();
                tieCount++;
            }
        }

        // Display results
        System.out.println("\n" + CYAN + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
        System.out.println(BRIGHT_GREEN + "📊 EMOTION ANALYSIS COMPLETE" + RESET);
        System.out.println(CYAN + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);

        // Handle different cases
        if (maxScore == 0) {
            // Case 1: No emotions detected - NEUTRAL
            displayEmotion(CYAN, "NEUTRAL", 50, getNeutralFace(),
                    "You seem calm and balanced.");
        } else if (tieCount > 1) {
            // Case 2: Multiple emotions tied for highest
            System.out.println(BRIGHT_YELLOW + "\n⚠️  MULTIPLE DOMINANT EMOTIONS DETECTED!" + RESET);
            System.out.println("You're experiencing a mix of strong emotions:\n");

            // Display each tied emotion
            if (emotions.get("LOVE") == maxScore) {
                displayEmotionCompact(PURPLE, "LOVE", Math.min(maxScore, 100), getLoveFace());
            }
            if (emotions.get("HATE") == maxScore) {
                displayEmotionCompact(BRIGHT_RED, "HATE", Math.min(maxScore, 100), getHateFace());
            }
            if (emotions.get("FEAR") == maxScore) {
                displayEmotionCompact(YELLOW, "FEAR", Math.min(maxScore, 100), getFearFace());
            }
            if (emotions.get("HAPPY") == maxScore) {
                displayEmotionCompact(GREEN, "HAPPY", Math.min(maxScore, 100), getHappyFace());
            }
            if (emotions.get("SAD") == maxScore) {
                displayEmotionCompact(BLUE, "SAD", Math.min(maxScore, 100), getSadFace());
            }
            if (emotions.get("ANGRY") == maxScore) {
                displayEmotionCompact(RED, "ANGRY", Math.min(maxScore, 100), getAngryFace());
            }

            System.out.println("💭 Complex emotions detected. This shows emotional depth!");
        } else {
            // Case 3: Single dominant emotion
            if (emotions.get("LOVE") == maxScore) {
                displayEmotion(PURPLE, "LOVE", Math.min(maxScore, 100), getLoveFace(),
                        "Your heart is full of affection and warmth!");
            } else if (emotions.get("HATE") == maxScore) {
                displayEmotion(BRIGHT_RED, "HATE", Math.min(maxScore, 100), getHateFace(),
                        "You're feeling strong dislike or resentment.");
            } else if (emotions.get("FEAR") == maxScore) {
                displayEmotion(YELLOW, "FEAR", Math.min(maxScore, 100), getFearFace(),
                        "You're experiencing worry or anxiety.");
            } else if (emotions.get("HAPPY") == maxScore) {
                displayEmotion(GREEN, "HAPPY", Math.min(maxScore, 100), getHappyFace(),
                        "You're in a positive and joyful state!");
            } else if (emotions.get("SAD") == maxScore) {
                displayEmotion(BLUE, "SAD", Math.min(maxScore, 100), getSadFace(),
                        "You're feeling down or melancholic.");
            } else if (emotions.get("ANGRY") == maxScore) {
                displayEmotion(RED, "ANGRY", Math.min(maxScore, 100), getAngryFace(),
                        "You're feeling frustrated or irritated.");
            }
        }

        // Show all detected emotions with bars
        displayAllEmotions(emotions, maxScore);
    }

    public static int getWordIntensity(String word) {
        // Extreme intensity words (40 points)
        String[] extremeWords = {
                "ecstatic", "elated", "euphoric", "rapturous", "blissful", "jubilant",
                "devastated", "shattered", "crushed", "agonized", "tortured", "inconsolable",
                "furious", "enraged", "livid", "incandescent", "ballistic", "explosive",
                "terrified", "horrified", "petrified", "paralyzed", "panic", "hysterical",
                "adore", "worship", "idolize", "obsessed", "captivated", "smitten",
                "loathe", "despise", "detest", "abhor", "execrate", "abominable"
        };

        // High intensity words (30 points)
        String[] highWords = {
                "thrilled", "delighted", "wonderful", "fantastic", "amazing", "brilliant",
                "heartbroken", "miserable", "wretched", "despairing", "grief", "anguish",
                "outraged", "infuriated", "seething", "wrathful", "fierce", "irate",
                "frightened", "panicked", "alarmed", "dread", "terror", "nightmare",
                "love", "cherish", "passionate", "infatuated", "enamored", "devotion",
                "hate", "disgust", "revolting", "repulsive", "nauseating", "vile"
        };

        // Medium intensity words (20 points) - default
        String[] mediumWords = {
                "happy", "glad", "cheerful", "content", "pleased", "satisfied",
                "sad", "unhappy", "gloomy", "down", "disappointed", "hurt",
                "angry", "mad", "upset", "irritated", "frustrated", "annoyed",
                "scared", "afraid", "worried", "anxious", "nervous", "uneasy",
                "like", "fond", "caring", "sweet", "tender", "affection",
                "dislike", "resent", "aversion", "disdain", "scorn", "bitter"
        };

        // Low intensity words (10 points)
        String[] lowWords = {
                "okay", "fine", "alright", "peaceful", "calm", "serene",
                "blue", "low", "somber", "pensive", "melancholy",
                "bothered", "cranky", "grumpy", "peeved", "miffed",
                "cautious", "hesitant", "uneasy", "apprehensive", "jittery",
                "pleasant", "charming", "lovely", "nice", "friendly",
                "annoyed", "irked", "offended", "bothered"
        };

        for (String extreme : extremeWords) {
            if (word.equals(extreme)) return 40;
        }
        for (String high : highWords) {
            if (word.equals(high)) return 30;
        }
        for (String low : lowWords) {
            if (word.equals(low)) return 10;
        }

        return 20; // Default medium intensity
    }

    public static void displayEmotion(String color, String emotion, int intensity, String face, String message) {
        System.out.println("\n" + color + face + RESET);
        System.out.println(color + "╔════════════════════════════════════╗" + RESET);
        System.out.println(color + "║  DOMINANT EMOTION: " + emotion + " ".repeat(19 - emotion.length()) + "║" + RESET);
        System.out.println(color + "║  INTENSITY: " + intensity + "%" + " ".repeat(22 - String.valueOf(intensity).length()) + "║" + RESET);
        System.out.println(color + "╚════════════════════════════════════╝" + RESET);
        System.out.println("💭 " + message);
    }

    public static void displayEmotionCompact(String color, String emotion, int intensity, String face) {
        System.out.println(color + face + RESET);
        System.out.println(color + "→ " + emotion + " (" + intensity + "%)" + RESET + "\n");
    }

    public static void displayAllEmotions(Map<String, Integer> emotions, int maxScore) {
        System.out.println("\n" + CYAN + "📈 All Detected Emotions:" + RESET);

        // Display in order with proper colors
        if (emotions.get("HAPPY") > 0)
            printBar("Happy", emotions.get("HAPPY"), GREEN, emotions.get("HAPPY") == maxScore);
        if (emotions.get("SAD") > 0)
            printBar("Sad", emotions.get("SAD"), BLUE, emotions.get("SAD") == maxScore);
        if (emotions.get("ANGRY") > 0)
            printBar("Angry", emotions.get("ANGRY"), RED, emotions.get("ANGRY") == maxScore);
        if (emotions.get("FEAR") > 0)
            printBar("Fear", emotions.get("FEAR"), YELLOW, emotions.get("FEAR") == maxScore);
        if (emotions.get("LOVE") > 0)
            printBar("Love", emotions.get("LOVE"), PURPLE, emotions.get("LOVE") == maxScore);
        if (emotions.get("HATE") > 0)
            printBar("Hate", emotions.get("HATE"), BRIGHT_RED, emotions.get("HATE") == maxScore);

        // Show neutral if no emotions detected
        if (maxScore == 0) {
            printBar("Neutral", 50, CYAN, true);
        }

        System.out.println(CYAN + "\n💡 Tip: The ⭐ marks the strongest emotion(s)." + RESET);
    }

    public static void printBar(String emotion, int value, String color, boolean isDominant) {
        int normalizedValue = Math.min(value, 100);
        int barLength = normalizedValue / 5;
        String bar = "█".repeat(Math.max(0, barLength));
        String marker = isDominant ? " ⭐" : "";
        System.out.println(String.format("  %-8s %s%-20s%s %3d%%%s",
                emotion + ":", color, bar, RESET, normalizedValue, marker));
    }

    // ASCII Art Faces
    public static String getHappyFace() {
        return """
            
               😊
            ╔═══════╗
            ║ ^   ^ ║
            ║   ◡   ║
            ╚═══════╝
            """;
    }

    public static String getSadFace() {
        return """
            
               😢
            ╔═══════╗
            ║ ˘   ˘ ║
            ║   ⌢   ║
            ╚═══════╝
            """;
    }

    public static String getAngryFace() {
        return """
            
               😠
            ╔═══════╗
            ║ >   < ║
            ║   -   ║
            ╚═══════╝
            """;
    }

    public static String getFearFace() {
        return """
            
               😨
            ╔═══════╗
            ║ O   O ║
            ║  ~~~  ║
            ╚═══════╝
            """;
    }

    public static String getLoveFace() {
        return """
            
               😍
            ╔═══════╗
            ║ ♥   ♥ ║
            ║   v   ║
            ╚═══════╝
            """;
    }

    public static String getHateFace() {
        return """
            
               😡
            ╔═══════╗
            ║ X   X ║
            ║ ╲╱╲╱╲╱║
            ╚═══════╝
            """;
    }

    public static String getNeutralFace() {
        return """
            
               😐
            ╔═══════╗
            ║ •   • ║
            ║   -   ║
            ╚═══════╝
            """;
    }
}
