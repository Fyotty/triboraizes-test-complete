-- alter_table_product_add_generics

-- Adiciona coluna uuid
ALTER TABLE product
    ADD COLUMN IF NOT EXISTS uuid UUID UNIQUE NOT NULL;

-- Adiciona coluna active
ALTER TABLE product
    ADD COLUMN IF NOT EXISTS active BOOLEAN NOT NULL DEFAULT TRUE;

-- Adiciona coluna created_at
ALTER TABLE product
    ADD COLUMN IF NOT EXISTS created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

-- Adiciona coluna updated_at
ALTER TABLE product
    ADD COLUMN IF NOT EXISTS updated_at TIMESTAMP NULL;

