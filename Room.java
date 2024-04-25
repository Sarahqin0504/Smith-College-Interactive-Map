public abstract class Room {
    public void enter() {
        System.out.println("You have entered the room. Explore its unique features!");
    }
}

class ChurchGallery extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("The Church Gallery is located in the front of the building downstairs from the reception area. It serves as a space for education, featuring changing exhibitions on a variety of botanical and horticultural themes.");
    }
}

class SucculentHouse extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("This is the Succulent House, the oldest section of Lyman, built in 1894. It holds xerophytes, or plants adapted to deserts and dry habitats, including New World cacti, Old World succulent euphorbias, and plants from families such as the Crassulaceae and Asphodelaceae.");
    }
}

class ShowHouse extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("Welcome to the Show House, where the first flower shows were staged. Today, it contains plants with foliar and floral scents, including salvias, mints, and geraniums, used in culinary, medicinal, and perfumery applications.");
    }
}

class FernHouse extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("The Fern House, with its curved glass ceiling, holds many non-hardy ferns, fern allies, and ancient plant lineages such as cycads and other early gymnosperms.");
    }
}

class PalmHouse extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("The stately Palm House is filled with plants from tropical forests worldwide, featuring palms, trees, climbers, and epiphytes, in a warm and humid environment.");
    }
}

class StoveHouse extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("Stove House is populated with tropical orchids, bromeliads, and aquatic plants around the center pool. It originally housed the wood stove that warmed this section.");
    }
}

class ColdStorageHouse extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("The Cold Storage House, built in 1902, currently hosts the Spring Bulb and Fall Mum Show and serves as a display space for large flowering woody plants.");
    }
}

class PhysiologyHouse extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("This is the Physiology House, originally a laboratory and now hosting plant physiology classes. It also hosts the Spring Bulb and Fall Mum Shows.");
    }
}

class CoolTemperateHouse extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("Cool Temperate House showcases trees and shrubs from tropical montane or subtropical regions, requiring cool winter growing conditions.");
    }
}

class CamelliaCorridor extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("The Camellia Corridor, reminiscent of European orangeries, grows plants that tolerate cool winter temperatures like camellias, citrus, and orchids.");
    }
}

class GeneticsHouse extends Room {
    @Override
    public void enter() {
        super.enter();
        System.out.println("The Genetics House is part of the Blakeslee Range, used for holding dormant plants, growing out small or recently received plants, and staging flower shows.");
    }
}
