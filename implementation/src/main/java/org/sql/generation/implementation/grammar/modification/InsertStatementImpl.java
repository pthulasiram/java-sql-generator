/*
 * Copyright (c) 2010, Stanislav Muhametsin. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.sql.generation.implementation.grammar.modification;

import org.atp.spi.TypeableImpl;
import org.sql.generation.api.common.NullArgumentException;
import org.sql.generation.api.grammar.common.TableNameDirect;
import org.sql.generation.api.grammar.modification.ColumnSource;
import org.sql.generation.api.grammar.modification.InsertStatement;

/**
 * 
 * @author Stanislav Muhametsin
 */
public class InsertStatementImpl extends TypeableImpl<InsertStatement, InsertStatement>
    implements InsertStatement
{

    private final TableNameDirect _tableName;
    private final ColumnSource _columnSource;

    public InsertStatementImpl( TableNameDirect tableName, ColumnSource columnSource )
    {
        this( InsertStatement.class, tableName, columnSource );
    }

    protected InsertStatementImpl( Class<? extends InsertStatement> expressionClass, TableNameDirect tableName,
        ColumnSource columnSource )
    {
        super( expressionClass );

        NullArgumentException.validateNotNull( "tableName", tableName );
        NullArgumentException.validateNotNull( "column source", columnSource );

        this._tableName = tableName;
        this._columnSource = columnSource;
    }

    public TableNameDirect getTableName()
    {
        return this._tableName;
    }

    public ColumnSource getColumnSource()
    {
        return this._columnSource;
    }

    @Override
    protected boolean doesEqual( InsertStatement another )
    {
        return this._tableName.equals( another.getTableName() )
            && this._columnSource.equals( another.getColumnSource() );
    }
}
